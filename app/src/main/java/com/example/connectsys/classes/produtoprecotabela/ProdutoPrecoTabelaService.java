package com.example.connectsys.classes.produtoprecotabela;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoPrecoTabelaService {

    @GET("produtoprecotabela")
    Call<List<ProdutoPrecoTabela>> listaProdutoPrecoTabela();
}
