package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.produtoicmsnotafiscal.ProdutoIcmsNotaFiscal;
import com.example.connectsys.classes.produtoicmsnotafiscal.ProdutoIcmsNotaFiscalService;
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

public class SincProdutoIcmsNotaFiscal {
    public void iniciaSinc(final Context context, List<ProdutoIcmsNotaFiscal> produtoIcmsNotaFiscalList) {

        ProdutoIcmsNotaFiscal produtoIcmsNotaFiscal = new ProdutoIcmsNotaFiscal();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(produtoIcmsNotaFiscal.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; produtoIcmsNotaFiscalList.size() != i; i++) {
            Sessao.colocaTexto("Cadastro de ICMS dos produtos.   " + (i + 1) + " de " + produtoIcmsNotaFiscalList.size());
            boolean retorno = produtoIcmsNotaFiscal.cadastraProdutoIcmsNotaFiscal(context, produtoIcmsNotaFiscalList.get(i));
        }

    }

    public void iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        ProdutoIcmsNotaFiscal produtoIcmsNotaFiscal = new ProdutoIcmsNotaFiscal();
        ProdutoIcmsNotaFiscalService produtoIcmsNotaFiscalService = retrofit.create(ProdutoIcmsNotaFiscalService.class);
        final Call<List<ProdutoIcmsNotaFiscal>> requestprodutoPrecoTabelas = produtoIcmsNotaFiscalService.listaprodutoicmsnotafiscal();
        final Response<List<ProdutoIcmsNotaFiscal>>[] response = new Response[]{null};
        List<ProdutoIcmsNotaFiscal> produtoIcmsNotaFiscalList = null;

        Sessao.colocaTexto("Consultando dados dos ICMS dos produtos.");
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar ICMS dos produtos.");
            }

            if (response[0] != null) {
                produtoIcmsNotaFiscalList = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (produtoIcmsNotaFiscalList != null) {
            iniciaSinc(context, produtoIcmsNotaFiscalList);

        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar ICMS dos produtos.");

        }
    }
}
