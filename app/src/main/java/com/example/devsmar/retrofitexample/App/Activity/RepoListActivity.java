package com.example.devsmar.retrofitexample.App.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devsmar.retrofitexample.App.Adapter.RepoListAdapter;
import com.example.devsmar.retrofitexample.R;
import com.example.devsmar.retrofitexample.Retrofit.Common.Common;
import com.example.devsmar.retrofitexample.Retrofit.Interface.GithubRepoService;
import com.example.devsmar.retrofitexample.Retrofit.Model.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Model> list = new ArrayList<>();
    GithubRepoService service;
    RepoListAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        Intent intent = getIntent();
        String nameOfClient = intent.getStringExtra("name");

       recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = findViewById(R.id.progressBar);

        service = Common.getRepos();
        service.getRepoDetails(nameOfClient).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()){
                    adapter = new RepoListAdapter(response);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(RepoListActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
