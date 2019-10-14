package com.example.connectsys.classes.vendedor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 18/05/2017.
 */

public interface VendedorService {
    @GET("vendedor")
    Call<List<Vendedor>> listVendedor();
}
