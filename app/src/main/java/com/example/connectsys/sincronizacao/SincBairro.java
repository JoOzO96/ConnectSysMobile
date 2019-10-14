package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.bairro.Bairro;
import com.example.connectsys.classes.bairro.BairroService;
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
}
