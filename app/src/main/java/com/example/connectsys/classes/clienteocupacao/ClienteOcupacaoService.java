package com.example.connectsys.classes.clienteocupacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 18/05/2017.
 */

public interface ClienteOcupacaoService {
    @GET("clienteocupacao")
    Call<List<ClienteOcupacao>> listclienteocupacao();
}
