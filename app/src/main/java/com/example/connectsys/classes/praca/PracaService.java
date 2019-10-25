package com.example.connectsys.classes.praca;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 25/05/2017.
 */

public interface PracaService {
    @GET("praca")
    Call<List<Praca>> listPraca();
}
