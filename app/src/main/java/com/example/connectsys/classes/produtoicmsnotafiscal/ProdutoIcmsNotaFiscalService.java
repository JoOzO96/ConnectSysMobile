package com.example.connectsys.classes.produtoicmsnotafiscal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoIcmsNotaFiscalService {

    @GET("produtoicmsnotafiscal")
    Call<List<ProdutoIcmsNotaFiscal>> listaprodutoicmsnotafiscal();
}
