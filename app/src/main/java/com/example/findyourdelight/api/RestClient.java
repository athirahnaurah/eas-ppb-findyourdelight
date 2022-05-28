package com.example.findyourdelight.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static InterfaceApi service;

    public static  InterfaceApi getService(){
        if(service == null){
            String BASE_URL = "https://foodbukka.herokuapp.com/api/v1/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            service = retrofit.create(InterfaceApi.class);
        }
        return service;
    }



}
