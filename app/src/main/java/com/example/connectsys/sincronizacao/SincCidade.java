package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.database.Cursor;

import com.example.connectsys.classes.cidade.Cidade;
import com.example.connectsys.classes.cidade.CidadeService;
import com.example.connectsys.uteis.GetSetDinamico;
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

public class SincCidade {
    public void iniciaSinc(final Context context, List<Cidade> cidadeList) {
        final Context context1;
        context1 = context;
        RetRetrofit retRetrofit = new RetRetrofit();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        Cidade cidade = new Cidade();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(cidade.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        Cursor cursor = null;
        Object valorCampo = null;
        Object teste = null;
        String nomeCampo = null;

        if (cidadeList.size() != cidade.retornaNumeroDeCidades(context1)) {
            for (int cid = 0; cidadeList.size() != cid; cid++) {
                if (cidadeList.get(cid).getCodcidade() == null) {
                } else {
                    Sessao.colocaTexto("Cadastro de Cidade   " + (cid + 1) + " de " + cidadeList.size());

                    boolean retorno = cidade.cadastraCidade(context, cidadeList.get(cid));

                }
            }
        }

    }

    public boolean iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Cidade cidade = new Cidade();
        CidadeService cidadeService;
        cidadeService = retrofit.create(CidadeService.class);
        final Call<List<Cidade>> requestCidade = cidadeService.listCidade();
        final Response<List<Cidade>>[] response = new Response[]{null};
        List<Cidade> listaCidade = null;

        Sessao.colocaTexto("Consultando dados das cidades");
        final Date dataInicio = new Date();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestCidade.execute();
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar cidades.");
            }

            if (response[0] != null) {
                listaCidade = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (listaCidade != null) {
            iniciaSinc(context, listaCidade);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados do cliente.");
            return false;
        }
    }
}
