package com.example.connectsys.classes.formapagto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 18/05/2017.
 */

public interface FormaPagtoService {
    @GET("formapagto")
    Call<List<FormaPagto>> listFormapagto();
}
