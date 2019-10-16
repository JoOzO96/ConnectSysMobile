package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.database.Cursor;

import com.example.connectsys.classes.bairro.Bairro;
import com.example.connectsys.classes.bairro.BairroService;
import com.example.connectsys.controlecodigo.ControleCodigo;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;
import com.google.gson.Gson;

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

public class SincBairro {
    public void iniciaSinc(final Context context, List<Bairro> bairros) {

        Bairro bairro = new Bairro();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(bairro.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; bairros.size() != i; i++) {
            if (bairros.get(i).getCodbairro() == null) {
            } else {
                Sessao.colocaTexto("Cadastro de Bairros.   " + (i + 1) + " de " + bairros.size());

                boolean retorno = bairro.cadastraBairro(context, bairros.get(i));

            }
        }

    }

    public boolean iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Bairro bairro = new Bairro();
        BairroService bairroService;
        bairroService = retrofit.create(BairroService.class);
        final Call<List<Bairro>> requestBairro = bairroService.listBairro();
        final Response<List<Bairro>>[] response = new Response[]{null};
        List<Bairro> listaBairro = null;

        Sessao.colocaTexto("Consultando dados dos bairros.");
        final Date dataInicio = new Date();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestBairro.execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        try {
            thread.join(120000);

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar bairros.");
            }

            if (response[0] != null) {
                listaBairro = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (listaBairro != null) {
            iniciaSinc(context, listaBairro);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados dos bairros.");
            return false;
        }
    }

    public void iniciaenvio(Context context, String ip) {
        Bairro bairro = new Bairro();
        List<Bairro> bairroList = new ArrayList<>();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        List<Field> fieldListCliente = new ArrayList<>(Arrays.asList(Bairro.class.getDeclaredFields()));
        Cursor cursor = bairro.retornaBairroAlteradaAndroid(context, "cadastroandroid");
        Sessao.colocaTexto("Verificando bairros novos.");
        if (cursor.getCount() > 0) {
            for (long i = 0L; cursor.getCount() != i; i++) {
                bairro = new Bairro();
                for (int cid = 0; fieldListCliente.size() != cid; cid++) {
                    if (fieldListCliente.get(cid).getName().toLowerCase().equals("$change") ||
                            fieldListCliente.get(cid).getName().toLowerCase().equals("serialversionuid")) {
                    } else {
                        String tipo = getSetDinamico.retornaTipoCampo(fieldListCliente.get(cid));
                        Object retornoCursor = getSetDinamico.retornaValorCursor(tipo, fieldListCliente.get(cid).getName(), cursor);
                        Object clienteRetorno = getSetDinamico.insereField(fieldListCliente.get(cid), bairro, retornoCursor);
                        bairro = (Bairro) clienteRetorno;
                    }
                }
                bairroList.add(bairro);
                Sessao.colocaTexto("Enviando os dados dos bairoos." + (i + 1) + " de " + cursor.getCount());
                cursor.moveToNext();
            }
        }
        RetRetrofit retRetrofit = new RetRetrofit();
        if (bairroList.size() > 0) {
            Gson gson = new Gson();
            String gsonRetorno = gson.toJson(bairroList);
            EnviaJson enviaJson = new EnviaJson();
            String url = retRetrofit.retornaSring("bairro", ip);
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
                bairro = new Bairro();
                for (int i = 0; controleCodigoList.size() != i; i++) {
                    if (controleCodigoList.get(i).getCodigobanco() == 0) {
                        MostraToast mostraToast = new MostraToast();
                        mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro: " + controleCodigoList.get(i).getMensagem());
                    } else {
                        bairro.alteraCodBairro(context, controleCodigoList.get(i).getCodigoandroid(), controleCodigoList.get(i).getCodigobanco());
                        Sessao.removeBairro(controleCodigoList.get(i).getCodigoandroid());
                        Sessao.atualizaListaBairro(bairro.retornaBairro(context, controleCodigoList.get(i).getCodigobanco()));
                        bairro.removeBairroAlteradaAndroid(context, "cadastroandroid");
                    }
                }
            }
        }
    }
}
