package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.naturezaoperacao.NaturezaOperacao;
import com.example.connectsys.classes.naturezaoperacao.NaturezaOperacaoService;
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

public class SincNaturezaOperacao {
    public void iniciaSinc(final Context context, List<NaturezaOperacao> naturezaOperacaoList) {

        NaturezaOperacao naturezaOperacao = new NaturezaOperacao();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(naturezaOperacao.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; naturezaOperacaoList.size() != i; i++) {
            Sessao.colocaTexto("Cadastro de Natureza de operação.   " + (i + 1) + " de " + naturezaOperacaoList.size());
            boolean retorno = naturezaOperacao.cadastraNaturezaOperacao(context, naturezaOperacaoList.get(i));
        }

    }

    public void iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        NaturezaOperacao naturezaOperacao = new NaturezaOperacao();
        NaturezaOperacaoService naturezaOperacaoService = retrofit.create(NaturezaOperacaoService.class);
        final Call<List<NaturezaOperacao>> requestprodutoPrecoTabelas = naturezaOperacaoService.listnaturezaoperacao();
        final Response<List<NaturezaOperacao>>[] response = new Response[]{null};
        List<NaturezaOperacao> naturezaOperacaoList = null;

        Sessao.colocaTexto("Consultando dados das Naturezas de operações.");
        final Date dataInicio = new Date();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestprodutoPrecoTabelas.execute();
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar Naturezas de operações.");
            }

            if (response[0] != null) {
                naturezaOperacaoList = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (naturezaOperacao != null) {
            iniciaSinc(context, naturezaOperacaoList);
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar Naturezas de operações.");
        }
    }
}
