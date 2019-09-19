package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.mac.MacService;
import com.example.connectsys.uteis.Mac;
import com.example.connectsys.uteis.MostraToast;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SincMac {
    public String iniciasinc(Context context) {
        Date dataInicio = new Date();
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit();
        MacService loginService = retrofit.create(MacService.class);
        String ip = "";
        Mac mac = new Mac();

        Gson gson = new Gson();
        final Call<String> requestMac = loginService.retornaMac(mac.retornaMac(context));
        final Response<String>[] response = new Response[]{null};

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestMac.execute();
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (thread.isAlive()) {
            thread.interrupt();
            MostraToast mostraToast = new MostraToast();
//            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar forma de pagamento.");
        }
        if (response[0] != null) {
            ip = response[0].body();
        }


        return ip;
    }
}
