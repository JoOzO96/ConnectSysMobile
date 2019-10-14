package com.example.connectsys.sincronizacao;

import android.content.Context;

import com.example.connectsys.classes.vendedor.Vendedor;
import com.example.connectsys.classes.vendedor.VendedorService;
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
 * Created by Jose on 23/06/2017.
 */

public class SincVendedor {

    public void iniciaSinc(List<Vendedor> vendedorList) {
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        Vendedor vendedor = new Vendedor();
        List<Field> fieldListClasse = new ArrayList<>(Arrays.asList(Vendedor.class.getDeclaredFields()));
        for (int i = 0; vendedorList.size() != i; i++) {

            boolean retorno = vendedor.cadastraVendedor(Sessao.retornaContext(), vendedorList.get(i));

        }
    }

    public void iniciaASinc(Context context, String ip) {
        RetRetrofit retRetrofit = new RetRetrofit();
        Retrofit retrofit = retRetrofit.retornaRetrofit(ip);
        Date dataInicio = new Date();
        Sessao.colocaTexto("Consultando dados do vendedor.");
        VendedorService vendedorService = retrofit.create(VendedorService.class);
        final Call<List<Vendedor>> requestVendedor = vendedorService.listVendedor();
        final Response<List<Vendedor>>[] response = new Response[]{null};
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response[0] = requestVendedor.execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        List<Vendedor> listaVendedor = null;
        try {
            thread.join(120000);

            if (thread.isAlive()) {
                thread.interrupt();
                MostraToast mostraToast = new MostraToast();
                mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar vendedor.");
            }


            if (response[0].body() != null) {
                listaVendedor = new ArrayList<>(response[0].body());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(Sessao.retornaContext(), "Erro ao consultar vendedor.");
        }

        thread.interrupt();
        if (listaVendedor != null) {
            iniciaSinc(listaVendedor);
        } else {
            MostraToast mostraToast = new MostraToast();
            mostraToast.mostraToastLong(context, "Erro ao consultar dados do vendedor.");
        }
    }


}
