package com.example.connectsys.sincronizacao;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.clienteocupacao.ClienteOcupacao;
import com.example.connectsys.classes.clienteocupacao.ClienteOcupacaoService;
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

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Jose on 22/05/2017.
 */

public class SincClienteOcupacao extends Activity {


    public void iniciaSinc(final Context context, final List<ClienteOcupacao> clienteOcupacaoList) {
        Handler handler = Sessao.getHandler();
        final Context context1;
        RetRetrofit retRetrofit = new RetRetrofit();
        final GetSetDinamico getSetDinamico = new GetSetDinamico();
        final ClienteOcupacao clienteOcupacao = new ClienteOcupacao();

        for (int cli = 0; clienteOcupacaoList.size() != cli; cli++) {
            Cliente cliente = new Cliente();
            final int finalCli = cli;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Sessao.colocaTexto("Cadastro de ocupações. " + (finalCli + 1) + " de " + clienteOcupacaoList.size());
                }
            });
            boolean status = clienteOcupacao.cadastraClienteOcupacao(
                    context, clienteOcupacaoList.get(cli)
            );

        }
    }


    public boolean iniciaAsinc(final Context context, final String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        //SETA O RETROFIT COM OS DADOS QUE A CLASSE RETORNOU, PARA O SISTEMA
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Cliente cliInsere = new Cliente();
        final Mac mac = new Mac();
        ClienteOcupacaoService ocupacaoService = retrofit.create(ClienteOcupacaoService.class);
        final Call<List<ClienteOcupacao>> requestClienteOcupacao = ocupacaoService.listclienteocupacao();
        final Response<List<ClienteOcupacao>>[] response = new Response[]{null};
        List<Field> listaCampos = new ArrayList<>(Arrays.asList(cliInsere.getClass().getDeclaredFields()));
        Sessao.colocaTexto("Consultando dados. (Cliente Ocupação)");
        Date dataInicio = new Date();
        final String[] conteudo = {null};
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestClienteOcupacao.execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        List<ClienteOcupacao> listaClienteOcupacao = null;
        try {
            thread.join(120000);

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados das ocupações.");
            }

            if (response[0].body() != null) {
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

                listaClienteOcupacao = new ArrayList<>(response[0].body());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listaClienteOcupacao != null) {
            iniciaSinc(context, listaClienteOcupacao);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados das ocupações.");
            return false;
        }
    }

}
