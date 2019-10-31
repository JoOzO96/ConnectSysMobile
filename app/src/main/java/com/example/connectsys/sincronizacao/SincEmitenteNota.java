package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.os.Handler;

import com.example.connectsys.classes.emitentenota.EmitenteNota;
import com.example.connectsys.classes.emitentenota.EmitenteNotaService;
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

public class SincEmitenteNota {
    public boolean iniciaAsinc(final Context context, final String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        //SETA O RETROFIT COM OS DADOS QUE A CLASSE RETORNOU, PARA O SISTEMA
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        List<EmitenteNota> emitenteNota = new ArrayList<>();
        EmitenteNotaService emitenteNotaService = retrofit.create(EmitenteNotaService.class);
        final Call<List<EmitenteNota>> request = emitenteNotaService.listemitentenota();
        final Response<List<EmitenteNota>>[] response = new Response[]{null};
        List<Field> listaCampos = new ArrayList<>(Arrays.asList(emitenteNota.getClass().getDeclaredFields()));
        Sessao.colocaTexto("Consultando dados. (Emitente Nota)");
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
                            response[0] = request.execute();
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
                emitenteNota = response[0].body();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (emitenteNota != null) {
            iniciaSinc(context, emitenteNota);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(),
                    "Erro ao consultar dados do emitente.");

            return false;
        }
    }

    public void iniciaSinc(final Context context, List<EmitenteNota> emitenteNotaList) {
        Handler handler = Sessao.getHandler();
        final Context context1;
        RetRetrofit retRetrofit = new RetRetrofit();
        final GetSetDinamico getSetDinamico = new GetSetDinamico();
        EmitenteNota emitenteNota = new EmitenteNota();
        final List<Field> fieldList = new ArrayList<>(Arrays.asList(emitenteNotaList.getClass().getDeclaredFields()));
        for (int i = fieldList.size() - 1; 0 != i; i--) {
            if (fieldList.get(i).getName().toLowerCase().equals("$change") ||
                    fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
            }
        }
        for (int i = 0; emitenteNotaList.size() > i; i++) {
            boolean status = emitenteNota.cadastraEmitenteNota(context, emitenteNotaList.get(i));
        }
    }
}
