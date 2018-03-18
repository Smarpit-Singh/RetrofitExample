package com.example.devsmar.retrofitexample.Retrofit.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dev Smar on 3/14/2018.
 */

public class GithubRepoClient {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String baseUrl){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
