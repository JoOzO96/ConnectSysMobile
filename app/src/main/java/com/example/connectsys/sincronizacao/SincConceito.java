package com.example.connectsys.sincronizacao;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.example.connectsys.classes.cliente.Cliente;
import com.example.connectsys.classes.clienteconceito.ClienteConceito;
import com.example.connectsys.classes.clienteconceito.ClienteConceitoService;
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

public class SincConceito extends Activity {


    public void iniciaSinc(final Context context, final List<ClienteConceito> clienteConceitoList) {
        Handler handler = Sessao.getHandler();
        final Context context1;
        RetRetrofit retRetrofit = new RetRetrofit();
        final GetSetDinamico getSetDinamico = new GetSetDinamico();
        final ClienteConceito clienteConceito = new ClienteConceito();

        for (int cli = 0; clienteConceitoList.size() != cli; cli++) {
            Cliente cliente = new Cliente();
            final int finalCli = cli;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Sessao.colocaTexto("Cadastro de conceitos. " + (finalCli + 1) + " de " + clienteConceitoList.size());
                }
            });
            boolean status = clienteConceito.cadastraClienteConceito(
                    context, clienteConceitoList.get(cli)
            );

        }
    }


    public boolean iniciaAsinc(final Context context, final String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        //SETA O RETROFIT COM OS DADOS QUE A CLASSE RETORNOU, PARA O SISTEMA
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Cliente cliInsere = new Cliente();
        final Mac mac = new Mac();
        ClienteConceitoService clienteConceitoService = retrofit.create(ClienteConceitoService.class);
        final Call<List<ClienteConceito>> listclienteconceito = clienteConceitoService.listclienteconceito();
        final Response<List<ClienteConceito>>[] response = new Response[]{null};
        List<Field> listaCampos = new ArrayList<>(Arrays.asList(cliInsere.getClass().getDeclaredFields()));
        Sessao.colocaTexto("Consultando dados. (Cliente Conceito)");
        Date dataInicio = new Date();
        final String[] conteudo = {null};
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = listclienteconceito.execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        List<ClienteConceito> lista = null;
        try {
            thread.join(120000);

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados dos conceitos.");
            }

            if (response[0].body() != null) {
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

                lista = new ArrayList<>(response[0].body());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lista != null) {
            iniciaSinc(context, lista);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados dos conceitos.");
            return false;
        }
    }

}
