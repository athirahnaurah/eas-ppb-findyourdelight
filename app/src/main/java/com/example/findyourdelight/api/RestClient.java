package com.example.findyourdelight.api;

import android.util.Log;

import com.example.findyourdelight.models.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestClient {

    private static InterfaceApi service;
    public static String token = "";
    public RestClient(){

    }

    public static  InterfaceApi getService(){
        if(service == null){
            String BASE_URL = "https://foodbukka.herokuapp.com/api/v1/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + token)
                            .addHeader("Cookie","token="+token)
                            .build();
                    Log.d("Authorization", "Bearer " + token);
                    return chain.proceed(request);
                }
            });

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            service = retrofit.create(InterfaceApi.class);
        }
        return service;
    }



}
