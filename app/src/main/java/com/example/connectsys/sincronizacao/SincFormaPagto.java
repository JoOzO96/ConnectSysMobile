package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.formapagto.FormaPagto;
import com.example.connectsys.classes.formapagto.FormaPagtoService;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.MostraToast;
import com.example.connectsys.uteis.Sessao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SincFormaPagto {

    public void iniciaSinc(List<FormaPagto> formaPagtoList) {

        Sessao.colocaTexto("Consultando dados da Forma de Pagamento");
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        FormaPagto formaPagto = new FormaPagto();
        List<Field> fieldListClasse = new ArrayList<>(Arrays.asList(FormaPagto.class.getDeclaredFields()));
        for (int i = 0; formaPagtoList.size() != i; i++) {
            Sessao.colocaTexto("Cadastrando Forma de Pagamento. " + (i + 1) + " de " + formaPagtoList.size());
            boolean retorno = formaPagto.cadastraFormaPagto(Sessao.retornaContext(), formaPagtoList.get(i));
        }
    }

    public void iniciaASinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        FormaPagtoService formaPagamentoService = retrofit.create(FormaPagtoService.class);
        final Call<List<FormaPagto>> requestFormaPagamento = formaPagamentoService.listFormapagto();

        final Response<List<FormaPagto>>[] response = new Response[]{null};

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestFormaPagamento.execute();
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
            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar forma de pagamento.");
        }

        List<FormaPagto> listaFormaPagamento = null;
        if (response[0] != null) {
            listaFormaPagamento = new ArrayList<>(response[0].body());
        }


        thread.interrupt();
        if (listaFormaPagamento != null) {
            iniciaSinc(listaFormaPagamento);
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados da forma de pagamento.");
        }

    }
}
