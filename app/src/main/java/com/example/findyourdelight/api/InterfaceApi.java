package com.example.findyourdelight.api;

import com.example.findyourdelight.models.BodyLogin;
import com.example.findyourdelight.models.BodyRegister;
import com.example.findyourdelight.models.LoginResponse;
import com.example.findyourdelight.models.MenuResponse;
import com.example.findyourdelight.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface InterfaceApi {
    @POST("auth/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @POST("auth/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @Headers("Content-Type: application/json")
    @GET("menu")
    Call<MenuResponse> getAllMenu();

}
