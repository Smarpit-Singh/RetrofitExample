package com.example.devsmar.retrofitexample.Retrofit.Common;

import com.example.devsmar.retrofitexample.Retrofit.Interface.GithubRepoService;
import com.example.devsmar.retrofitexample.Retrofit.Remote.GithubRepoClient;

/**
 * Created by Dev Smar on 3/13/2018.
 */

public class Common {

    public static final String BASE_URL = "https://api.github.com/";

    public static GithubRepoService getRepos(){
        return GithubRepoClient.getRetrofit(BASE_URL).create(GithubRepoService.class);
    }
}
