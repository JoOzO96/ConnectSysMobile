package com.example.connectsys.classes.configuracaogeral;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jose on 18/05/2017.
 */

public interface ConfiguracaoGeralService {
    @GET("configuracaogeral")
    Call<ConfiguracaoGeral> listconfiguracaogeral();
}
