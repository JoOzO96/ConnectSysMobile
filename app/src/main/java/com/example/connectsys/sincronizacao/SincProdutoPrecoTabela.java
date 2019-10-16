package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.produtoprecotabela.ProdutoPrecoTabela;
import com.example.connectsys.classes.produtoprecotabela.ProdutoPrecoTabelaService;
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

public class SincProdutoPrecoTabela {
    public void iniciaSinc(final Context context, List<ProdutoPrecoTabela> produtoPrecoTabelas) {

        ProdutoPrecoTabela produtoPrecoTabela = new ProdutoPrecoTabela();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(produtoPrecoTabela.getClass().getDeclaredFields()));
        for (int i = 0; fieldList.size() != i; i++) {
            if (fieldList.get(i).getName().equals("$change") || fieldList.get(i).getName().toLowerCase().equals("serialversionuid")) {
                fieldList.remove(i);
                i = 0;
            }
        }
        for (int i = 0; produtoPrecoTabelas.size() != i; i++) {
            Sessao.colocaTexto("Cadastro de Tabela de preços.   " + (i + 1) + " de " + produtoPrecoTabelas.size());
            boolean retorno = produtoPrecoTabela.cadastraProdutoPrecoTabela(context, produtoPrecoTabelas.get(i));
        }

    }

    public boolean iniciaAsinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        ProdutoPrecoTabela produtoPrecoTabela = new ProdutoPrecoTabela();
        ProdutoPrecoTabelaService tabelaPrecoService = retrofit.create(ProdutoPrecoTabelaService.class);
        final Call<List<ProdutoPrecoTabela>> requestprodutoPrecoTabelas = tabelaPrecoService.listaProdutoPrecoTabela();
        final Response<List<ProdutoPrecoTabela>>[] response = new Response[]{null};
        List<ProdutoPrecoTabela> produtoPrecoTabelas = null;

        Sessao.colocaTexto("Consultando dados das tabelas de preços.");
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
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar tabela de preços.");
            }

            if (response[0] != null) {
                produtoPrecoTabelas = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (produtoPrecoTabelas != null) {
            iniciaSinc(context, produtoPrecoTabelas);
            return true;
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar tabela de preços.");
            return false;
        }
    }
}
