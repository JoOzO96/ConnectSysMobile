package com.example.connectsys.classes.mac;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jose on 18/05/2017.
 */

public interface MacService {
    @GET("mac/{macAddress}")
    Call<String> retornaMac(@Path("macAddress") String macAddress);
}
