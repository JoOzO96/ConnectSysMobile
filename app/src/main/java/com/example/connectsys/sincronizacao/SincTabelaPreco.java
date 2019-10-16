package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.tabelapreco.TabelaPreco;
import com.example.connectsys.classes.tabelapreco.TabelaPrecoService;
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

public class SincTabelaPreco {
    public void iniciaSinc(final Context context, List<TabelaPreco> tabelaPrecos) {

        TabelaPreco tabelaPreco = new TabelaPreco();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(tabelaPreco.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; tabelaPrecos.size() != i; i++) {
            Sessao.colocaTexto("Cadastro de Tabela de preços.   " + (i + 1) + " de " + tabelaPrecos.size());
            boolean retorno = tabelaPreco.cadastraTabelaPreco(context, tabelaPrecos.get(i));
        }

    }

    public boolean iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        TabelaPreco tabelaPreco = new TabelaPreco();
        TabelaPrecoService tabelaPrecoService = retrofit.create(TabelaPrecoService.class);
        final Call<List<TabelaPreco>> requestBairro = tabelaPrecoService.listaTabelaPreco();
        final Response<List<TabelaPreco>>[] response = new Response[]{null};
        List<TabelaPreco> tabelaPrecos = null;

        Sessao.colocaTexto("Consultando dados das tabelas de preços.");
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar tabela de preços.");
            }

            if (response[0] != null) {
                tabelaPrecos = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tabelaPrecos != null) {
            iniciaSinc(context, tabelaPrecos);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar tabela de preços.");
            return false;
        }
    }
}
