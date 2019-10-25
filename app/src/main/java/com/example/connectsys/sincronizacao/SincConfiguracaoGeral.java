package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.os.Handler;

import com.example.connectsys.classes.configuracaogeral.ConfiguracaoGeral;
import com.example.connectsys.classes.configuracaogeral.ConfiguracaoGeralService;
import com.example.connectsys.uteis.DateDeserializer;
import com.example.connectsys.uteis.GetSetDinamico;
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

public class SincConfiguracaoGeral {
    public boolean iniciaAsinc(final Context context, final String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        //SETA O RETROFIT COM OS DADOS QUE A CLASSE RETORNOU, PARA O SISTEMA
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        ConfiguracaoGeral configuracaoGeral = new ConfiguracaoGeral();
        ConfiguracaoGeralService configuracaoGeralService = retrofit.create(ConfiguracaoGeralService.class);
        final Call<ConfiguracaoGeral> requestConfiguracao = configuracaoGeralService.listconfiguracaogeral();
        final Response<ConfiguracaoGeral>[] response = new Response[]{null};
        List<Field> listaCampos = new ArrayList<>(Arrays.asList(configuracaoGeral.getClass().getDeclaredFields()));
        Sessao.colocaTexto("Consultando dados. (Configurações)");
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();
        Date dataInicio = new Date();
        final String[] conteudo = {null};

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestConfiguracao.execute();
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
                mostraToast.mostraToastLong(Sessao.retornaContext(),
                        "Erro ao consultar emitente.");
            }

            if (response[0].body() != null) {
                configuracaoGeral = response[0].body();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (configuracaoGeral != null) {
            iniciaSinc(context, configuracaoGeral);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(),
                    "Erro ao consultar dados do emitente.");

            return false;
        }
    }

    public void iniciaSinc(final Context context, final ConfiguracaoGeral configuracaoGeral) {
        Handler handler = Sessao.getHandler();
        final Context context1;
        RetRetrofit retRetrofit = new RetRetrofit();
        final GetSetDinamico getSetDinamico = new GetSetDinamico();

        final List<Field> fieldList = new ArrayList<>(Arrays.asList(configuracaoGeral.getClass().getDeclaredFields()));
        for (int i = fieldList.size() - 1; 0 != i; i--) {
            if (fieldList.get(i).getName().toLowerCase().equals("$change") ||
                    fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
            }
        }

        boolean status = configuracaoGeral.cadastraEmitente(context, configuracaoGeral);


    }


}
