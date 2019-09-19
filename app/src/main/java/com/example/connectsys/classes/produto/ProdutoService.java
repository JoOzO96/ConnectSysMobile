package com.example.connectsys.classes.produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoService {

    @GET("produto")
    Call<List<Produto>> listaProduto();
}
