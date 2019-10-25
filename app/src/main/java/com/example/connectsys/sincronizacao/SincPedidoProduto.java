package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.util.Log;

import com.example.connectsys.classes.pedidoproduto.PedidoItem;
import com.example.connectsys.controlecodigo.ControleCodigo;
import com.example.connectsys.uteis.GetSetDinamico;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jose on 11/07/2017.
 */

public class SincPedidoProduto {

    public void iniciaenvio(Context context, String ip, Long pedido) {
        try {
            PedidoItem pedidoItem = new PedidoItem();
            List<PedidoItem> pedidoProdutoList = new ArrayList<>();
            GetSetDinamico getSetDinamico = new GetSetDinamico();
            List<Field> fieldListPedido = new ArrayList<>(Arrays.asList(PedidoItem.class.getDeclaredFields()));
//            pedidoProduto.colocaPedidoProdutoAlteradaAndroid(context, "cadastroandroid");
            pedidoProdutoList = pedidoItem.retornaItensPedido(context, pedido);

            if (pedidoProdutoList.size() > 0) {
                Gson gson = new Gson();
                String gsonRetorno = gson.toJson(pedidoProdutoList);
                Log.i("JSONPEDIDOPRODUTO", gsonRetorno);
                EnviaJson enviaJson = new EnviaJson();
//            String url = "http://177.92.186.84:15101/ConnectServices/recebePedidoProduto";
                RetRetrofit retRetrofit = new RetRetrofit();
                String url = retRetrofit.retornaSring("pedidoitem", ip);
                List<ControleCodigo> retorno = null;
                String retornoEnvio = "";
                try {
                    enviaJson.execute(gsonRetorno, url);
                    retornoEnvio = enviaJson.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (retornoEnvio != null && retornoEnvio != "") {

                    ControleCodigo[] conversao = gson.fromJson(retornoEnvio, ControleCodigo[].class);
                    if (conversao != null) {
                        List<ControleCodigo> controleCodigoList = new ArrayList<>(Arrays.asList(conversao));

                        pedidoItem = new PedidoItem();
                        for (int i = 0; controleCodigoList.size() != i; i++) {

                        }
                        pedidoItem.removePedidoProdutoAlteradaAndroid(context, "cadastroandroid");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
