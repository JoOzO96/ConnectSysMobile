package com.example.connectsys.classes.cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 18/05/2017.
 */

public interface ClienteEnderecoService {
    @GET("clienteendereco")
    Call<List<ClienteEndereco>> listClienteEndereco();
}
