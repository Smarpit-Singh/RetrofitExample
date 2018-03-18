package com.example.devsmar.retrofitexample.Retrofit.Interface;

import com.example.devsmar.retrofitexample.Retrofit.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dev Smar on 3/14/2018.
 */

public interface GithubRepoService {

    @GET("users/{user}/repos")
    Call<List<Model>> getRepoDetails(@Path("user") String user);
}
