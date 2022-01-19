package com.example.digiticket_app_01.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IMyService {
    @POST("api/usuarios")
    @FormUrlEncoded
    Observable registrar(@Field("cod_usuario") String cod_usuario,
                         @Field("password") String password,
                         @Field("nombres") String nombres);

    @POST("api/usuarios/login")
    @FormUrlEncoded
    Observable<String> login(@Field("cod_usuario") String cod_usuario,
                     @Field("password") String password);

    @GET("api/usuarios")
    Observable<String> usuarios();
}
