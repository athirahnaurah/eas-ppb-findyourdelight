package com.example.findyourdelight.api;

import com.example.findyourdelight.models.BodyCreateMenu;
import com.example.findyourdelight.models.BodyLogin;
import com.example.findyourdelight.models.BodyRegister;
import com.example.findyourdelight.models.CreateMenuResponse;
import com.example.findyourdelight.models.LoginResponse;
import com.example.findyourdelight.models.MenuResponse;
import com.example.findyourdelight.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InterfaceApi {
    @POST("auth/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @POST("auth/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @GET("menu")
    Call<MenuResponse> getAllMenu();

    @POST("restaurant/{id}/menu")
    Call<CreateMenuResponse> createMenu(
            @Path("id") String id,
            @Body BodyCreateMenu bodyMenu
            );

    @PUT("menu/{id}")
    Call<CreateMenuResponse> updateMenu(@Path("id") String id, @Body BodyCreateMenu bodyUpdateMenu);
}
