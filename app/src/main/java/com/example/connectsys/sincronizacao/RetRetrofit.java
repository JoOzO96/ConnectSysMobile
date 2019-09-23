package com.example.connectsys.sincronizacao;

import com.example.connectsys.uteis.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jose on 26/05/2017.
 */

public class RetRetrofit {

    public Retrofit retornaRetrofit(String ip) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(3, TimeUnit.MINUTES)
                .build();
        Retrofit retrofit = null;
        if (ip.equals("") || ip == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://177.92.186.84:15101/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        } else {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://" + ip + "/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }

    public Retrofit retornaRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy")
                .create();
        Retrofit retrofit = null;
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(3, TimeUnit.MINUTES)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://177.92.186.84:15101/api/")
//                .baseUrl("http://192.168.56.1:45455/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public String retornaSring(String tipo, String ip) {
        String url = "";
        if (ip.equals("") || ip == null) {
            if (tipo.equals("cidade")) {
                url = "http://" + ip + "/api/cidade";
            } else if (tipo.equals("cliente")) {
                url = "http://" + ip + "/api/Cliente";
            } else if (tipo.equals("parcelas")) {
                url = "http://" + ip + "/api/parcelas";
            } else if (tipo.equals("pedido")) {
                url = "http://" + ip + "/api/Pedido";
            } else if (tipo.equals("pedidoproduto")) {
                url = "http://" + ip + "/api/PedidoProduto";
            }
        } else {
            if (tipo.equals("cidade")) {
                url = "http://" + ip + "/api/Cidade";
            } else if (tipo.equals("parcelas")) {
                url = "http://" + ip + "/api/parcelas";
            } else if (tipo.equals("cliente")) {
                url = "http://" + ip + "/api/Cliente";
            } else if (tipo.equals("pedido")) {
                url = "http://" + ip + "/api/Pedido";
            } else if (tipo.equals("pedidoproduto")) {
                url = "http://" + ip + "/api/PedidoProduto";
            }
        }
        return url;
    }


}