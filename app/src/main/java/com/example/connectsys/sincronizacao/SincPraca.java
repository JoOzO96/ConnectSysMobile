package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.praca.Praca;
import com.example.connectsys.classes.praca.PracaService;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SincPraca {
    public void iniciaSinc(final Context context, List<Praca> pracas) {

        Praca praca = new Praca();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(praca.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; pracas.size() != i; i++) {
            if (pracas.get(i).getCodpraca() == null) {
            } else {
                Sessao.colocaTexto("Cadastro de praças.   " + (i + 1) + " de " + pracas.size());

                boolean retorno = praca.cadastraPraca(context, pracas.get(i));

            }
        }

    }

    public boolean iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Praca praca = new Praca();
        PracaService pracaService;
        pracaService = retrofit.create(PracaService.class);
        final Call<List<Praca>> requestPraca = pracaService.listPraca();
        final Response<List<Praca>>[] response = new Response[]{null};
        List<Praca> listaPraca = null;

        Sessao.colocaTexto("Consultando dados das praças.");
        final Date dataInicio = new Date();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestPraca.execute();
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar praças.");
            }

            if (response[0] != null) {
                listaPraca = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (listaPraca != null) {
            iniciaSinc(context, listaPraca);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados das praças.");
            return false;
        }
    }
}
