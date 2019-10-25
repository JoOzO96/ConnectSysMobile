package com.example.connectsys.sincronizacao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.connectsys.classes.pedido.Pedido;
import com.example.connectsys.controlecodigo.ControleCodigo;
import com.example.connectsys.uteis.DateDeserializer;
import com.example.connectsys.uteis.GetSetDinamico;
import com.example.connectsys.uteis.Sessao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jose on 21/06/2017.
 */

public class SincPedido {

    public void iniciaenvio(Context context, String ip) {
        Pedido pedido = new Pedido();
        List<Pedido> pedidoList = new ArrayList<>();
        GetSetDinamico getSetDinamico = new GetSetDinamico();
        List<Field> fieldListPedido = new ArrayList<>(Arrays.asList(Pedido.class.getDeclaredFields()));
//        pedido.removePedidoAlteradaAndroid(context, "alteradoAndroid");
//        pedido.colocaPedidoAlteradaAndroid(context, "cadastroandroid");
        Cursor cursor = pedido.retornaPedidoAlteradaAndroid(context, "cadastroandroid");
        Sessao.colocaTexto("Verificando pedidos novos.");
        if (cursor.getCount() > 0) {
            for (long i = 0L; cursor.getCount() != i; i++) {
                pedido = new Pedido();
                for (int ped = 0; fieldListPedido.size() != ped; ped++) {
                    if (fieldListPedido.get(ped).getName().toLowerCase().equals("$change") ||
                            fieldListPedido.get(ped).getName().toLowerCase().equals("serialversionuid")) {
                    } else {
                        String tipo = getSetDinamico.retornaTipoCampo(fieldListPedido.get(ped));
                        Object retornoCursor = getSetDinamico.retornaValorCursor(tipo, fieldListPedido.get(ped).getName(), cursor);
                        Object pedidoRetorno = getSetDinamico.insereField(fieldListPedido.get(ped), pedido, retornoCursor);
                        pedido = (Pedido) pedidoRetorno;
                    }
                }
                pedidoList.add(pedido);

                cursor.moveToNext();
            }
        }
        if (pedidoList.size() > 0) {
            GsonBuilder gsonBuilder = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
            Gson gson = gsonBuilder.create();

            for (int i = 0; i < pedidoList.size(); i++) {
                EnviaJson enviaJson = new EnviaJson();
                RetRetrofit retRetrofit = new RetRetrofit();
                String url = retRetrofit.retornaSring("pedido", ip);
                List<ControleCodigo> retorno = null;
                String retornoEnvio = "";
                Date dataInicio = new Date();
                String gsonRetorno = gson.toJson(pedidoList.get(i));
                gsonRetorno = "[" + gsonRetorno + "]";
                Log.i("JSONPEDIDO", gsonRetorno);
                Sessao.colocaTexto("Enviando os dados de pedidos." + (i + 1) + " de " + pedidoList.size());
                try {
                    enviaJson.execute(gsonRetorno, url);
                    while (retornoEnvio == "") {
                        retornoEnvio = enviaJson.get();
                        if ((dataInicio.getTime() - System.currentTimeMillis()) <= -30000 || retornoEnvio != "") {
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (retornoEnvio != null && retornoEnvio != "") {
                    SincPedidoProduto sincPedidoProduto = new SincPedidoProduto();
                    ControleCodigo[] conversao = gson.fromJson(retornoEnvio, ControleCodigo[].class);
                    List<ControleCodigo> controleCodigoList = new ArrayList<>(Arrays.asList(conversao));
                    pedido = new Pedido();
                    for (int j = 0; controleCodigoList.size() != j; j++) {
                        pedidoList = pedido.alteraCodPedido(context, pedidoList.get(i).getCodpedido(), controleCodigoList.get(j).getCodigobanco(), pedidoList);
                        pedido.alteraCodPedidoProduto(context, pedidoList.get(i).getCodpedido(), controleCodigoList.get(j).getCodigobanco());

                        pedido.removePedidoAlteradaAndroid(context, "cadastroandroid", controleCodigoList.get(j).getCodigobanco());
                        sincPedidoProduto.iniciaenvio(context, ip, controleCodigoList.get(j).getCodigobanco());
                    }

                }
            }
        }
    }
}
