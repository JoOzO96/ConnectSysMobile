package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.connectsys.banco.Banco;
import com.example.connectsys.classes.produto.Produto;
import com.example.connectsys.classes.produto.ProdutoService;
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

/**
 * Created by Jose on 31/07/2017.
 */

public class SincProduto {

    public void iniciaSinc(List<Produto> listaProduto, Context context) {

        GetSetDinamico getSetDinamico = new GetSetDinamico();
        Produto produto = new Produto();
        produto.removeProdutos(Sessao.retornaContext());
        List<Field> fieldListClasse = new ArrayList<>(Arrays.asList(Produto.class.getDeclaredFields()));
        for (int i = 0; listaProduto.size() != i; i++) {
            Banco myDb = new Banco(Sessao.retornaContext());
            SQLiteDatabase db = myDb.getReadableDatabase();
            //TESTE SE O CODIGO JA ESTA NO BANCO DO CELULAR, SE NAO ESTIVER ELE IRA CADASTRAR
            produto = new Produto();
            Cursor cursor = produto.retornaProdutoFiltradaCursorSincro(db, listaProduto.get(i).getCodproduto());
            Sessao.colocaTexto("Cadastro de produtos.   " + (i + 1) + " de " + listaProduto.size());
            if (cursor.getCount() > 0) {
                cursor.close();
            } else {

                boolean retorno = produto.cadastraProdutoSincro(db, listaProduto.get(i));

                cursor.close();

            }
            db.close();
        }

//            }
//
//            @Override
//            public void onFailure(Call<List<Produto>> call, Throwable t) {
//                Log.e("DEU ERRO Sinc", t.toString());
//            }
//        });
    }


    public void iniciaASinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Date dataInicio = new Date();
        Long controlaWhile = 0L;
        Sessao.colocaTexto("Consultando dados dos produtos.");

        ProdutoService produtoService = retrofit.create(ProdutoService.class);
        final Call<List<Produto>> requestProduto = produtoService.listaProduto();
        final Response<List<Produto>>[] response = new Response[]{null};
        final String[] teste = {""};
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestProduto.execute();
                            while (response[0].isSuccessful()) {
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread.setName("ConsultaProduto");
        List<Produto> listaProduto = null;
        try {

            thread.join();

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar dados do produto.");
            }

            if (response[0].isSuccessful()) {
                listaProduto = new ArrayList<>(response[0].body());
            } else {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread.interrupt();
        if (listaProduto != null) {
            iniciaSinc(listaProduto, context);
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados do vendedor.");
        }
    }
}
