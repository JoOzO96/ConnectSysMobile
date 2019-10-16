package com.example.connectsys.sincronizacao;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.util.Log;

import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.cliente.ClienteEndereco;
import com.example.connectsys.classes.cliente.ClienteEnderecoService;
import com.example.connectsys.controlecodigo.ControleCodigo;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.Mac;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Jose on 22/05/2017.
 */

public class SincClienteEndereco extends Activity {


    public void iniciaSinc(final Context context, final List<ClienteEndereco> requestClienteEndereco) {
        Handler handler = Sessao.getHandler();
        final Context context1;
        RetRetrofit retRetrofit = new RetRetrofit();
        final GetSetDinamico getSetDinamico = new GetSetDinamico();
        final ClienteEndereco clienteEndereco = new ClienteEndereco();

        for (int cli = 0; requestClienteEndereco.size() != cli; cli++) {
            Cliente cliente = new Cliente();
            final int finalCli = cli;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Sessao.colocaTexto("Cadastro de endereços dos clientes. " + (finalCli + 1) + " de " + requestClienteEndereco.size());
                }
            });
            boolean status = clienteEndereco.cadastraClienteEndereco(
                    context, requestClienteEndereco.get(cli)
            );

        }
    }


    public boolean iniciaAsinc(final Context context, final String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        //SETA O RETROFIT COM OS DADOS QUE A CLASSE RETORNOU, PARA O SISTEMA
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Cliente cliInsere = new Cliente();
        final Mac mac = new Mac();
        ClienteEnderecoService clienteEndereco = retrofit.create(ClienteEnderecoService.class);
        final Call<List<ClienteEndereco>> requestClienteEndereco = clienteEndereco.listClienteEndereco();
        final Response<List<ClienteEndereco>>[] response = new Response[]{null};
        List<Field> listaCampos = new ArrayList<>(Arrays.asList(cliInsere.getClass().getDeclaredFields()));
        Sessao.colocaTexto("Consultando dados. (ClienteEndereco)");
        Date dataInicio = new Date();
        final String[] conteudo = {null};
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestClienteEndereco.execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        List<ClienteEndereco> listaClienteEndereco = null;
        try {
            thread.join(120000);

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar vendedor.");
            }

            if (response[0].body() != null) {
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

                listaClienteEndereco = new ArrayList<>(response[0].body());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listaClienteEndereco != null) {
            iniciaSinc(context, listaClienteEndereco);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados do cliente.");
            return false;
        }
    }

    public void iniciaenvio(Context context, String ip) {
        ClienteEndereco clienteEndereco = new ClienteEndereco();
        List<ClienteEndereco> clienteList = new ArrayList<>();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(ClienteEndereco.class.getDeclaredFields()));
        Cursor cursor = clienteEndereco.retornaClienteEnderecoAlteradaAndroid(context, "cadastroandroid");
        Sessao.colocaTexto("Verificando clientes novos.");
        if (cursor.getCount() > 0) {
            for (long i = 0L; cursor.getCount() != i; i++) {
                clienteEndereco = new ClienteEndereco();
                for (int cid = 0; fieldListCliente.size() != cid; cid++) {
                    if (fieldListCliente.get(cid).getName().toLowerCase().equals("$change") ||
                            fieldListCliente.get(cid).getName().toLowerCase().equals("serialversionuid")) {
                    } else {
                        String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(cid));
                        Object retornoCursor = getSetDinamico.retornaValorCursor(tipo, fieldListCliente.get(cid).getName(), cursor);
                        Object clienteRetorno = getSetDinamico.insereField(fieldListCliente.get(cid), clienteEndereco, retornoCursor);
                        clienteEndereco = (ClienteEndereco) clienteRetorno;
                    }
                }
                clienteList.add(clienteEndereco);
                Sessao.colocaTexto("Enviando os dados de clientes." + (i + 1) + " de " + cursor.getCount());
                cursor.moveToNext();
            }
        }
        RetRetrofit retRetrofit = new RetRetrofit();
        if (clienteList.size() > 0) {
            Gson gson = new Gson();
            String gsonRetorno = gson.toJson(clienteList);
            Log.e("JSON", gsonRetorno);
            EnviaJson enviaJson = new EnviaJson();
            String url = retRetrofit.retornaSring("clienteendereco", ip);
            List<ControleCodigo> retorno = null;
            String retornoEnvio = "";
            try {
                enviaJson.execute(gsonRetorno, url);
                retornoEnvio = enviaJson.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (retornoEnvio != null) {
                ControleCodigo[] conversao = gson.fromJson(retornoEnvio, ControleCodigo[].class);
                List<ControleCodigo> controleCodigoList = new ArrayList<>(Arrays.asList(conversao));
                clienteEndereco = new ClienteEndereco();
                for (int i = 0; controleCodigoList.size() != i; i++) {
                    if (controleCodigoList.get(i).getCodigobanco() == 0) {
                        MostraToast mostraToast = new MostraToast();
                        mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro: " + controleCodigoList.get(i).getMensagem());
                    } else {
                        clienteEndereco.alteraCodClienteEndereco(context, controleCodigoList.get(i).getCodigoandroid(), controleCodigoList.get(i).getCodigobanco());
                        clienteEndereco.removeClienteEnderecoAlteradaAndroid(context, "cadastroandroid");
                    }

                }
            }
        }
        clienteEndereco = new ClienteEndereco();
        clienteList = new ArrayList<>();
        getSetDinamico = new GetSetDinamico();
        fieldListCliente = new ArrayList<>(Arrays.asList(ClienteEndereco.class.getDeclaredFields()));
        cursor = clienteEndereco.retornaClienteEnderecoAlteradaAndroid(context, "alteradoandroid");

        if (cursor.getCount() > 0) {
            for (long i = 0L; cursor.getCount() != i; i++) {
                clienteEndereco = new ClienteEndereco();
                for (int cid = 0; fieldListCliente.size() != cid; cid++) {
                    if (fieldListCliente.get(cid).getName().toLowerCase().equals("$change") ||
                            fieldListCliente.get(cid).getName().toLowerCase().equals("serialversionuid")) {
                    } else {
                        String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(cid));
                        Object retornoCursor = getSetDinamico.retornaValorCursor(tipo, fieldListCliente.get(cid).getName(), cursor);
                        Object clienteRetorno = getSetDinamico.insereField(fieldListCliente.get(cid), clienteEndereco, retornoCursor);
                        clienteEndereco = (ClienteEndereco) clienteRetorno;
                    }
                }
                clienteList.add(clienteEndereco);

                cursor.moveToNext();
            }
        }
        if (clienteList.size() > 0) {
            Gson gson = new Gson();
            String gsonRetorno = gson.toJson(clienteList);
            EnviaJson enviaJson = new EnviaJson();
            String url = retRetrofit.retornaSring("cliente", ip);
            List<ControleCodigo> retorno = null;
            String retornoEnvio = "";
            try {
                enviaJson.execute(gsonRetorno, url);
                retornoEnvio = enviaJson.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            ControleCodigo[] conversao = gson.fromJson(retornoEnvio, ControleCodigo[].class);
            List<ControleCodigo> controleCodigoList = new ArrayList<>(Arrays.asList(conversao));
            clienteEndereco = new ClienteEndereco();
            for (int i = 0; controleCodigoList.size() != i; i++) {
                if (controleCodigoList.get(i).getCodigobanco() == 0) {
                    MostraToast mostraToast = new MostraToast();
                    mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro: " + controleCodigoList.get(i).getMensagem());
                } else {
                    clienteEndereco.removeClienteEnderecoAlteradaAndroid(context, "alteradoandroid");
                }

            }

        }
    }

}
