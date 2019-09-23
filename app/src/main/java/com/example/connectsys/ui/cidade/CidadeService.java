package com.example.connectsys.ui.cidade;

import com.example.connectsys.classes.cidade.Cidade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 25/05/2017.
 */

public interface CidadeService {
    @GET("cidade")
    Call<List<Cidade>> listCidade();
}
