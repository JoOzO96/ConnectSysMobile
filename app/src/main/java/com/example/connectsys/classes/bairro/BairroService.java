package com.example.connectsys.classes.bairro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 25/05/2017.
 */

public interface BairroService {
    @GET("bairro")
    Call<List<Bairro>> listBairro();
}
