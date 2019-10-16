package com.example.connectsys.classes.tabelapreco;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TabelaPrecoService {

    @GET("tabelapreco")
    Call<List<TabelaPreco>> listaTabelaPreco();
}
