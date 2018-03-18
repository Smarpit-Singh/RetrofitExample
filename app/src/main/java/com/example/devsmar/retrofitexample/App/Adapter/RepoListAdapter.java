package com.example.devsmar.retrofitexample.App.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devsmar.retrofitexample.R;
import com.example.devsmar.retrofitexample.Retrofit.Model.Model;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Dev Smar on 3/14/2018.
 */

class RepoViewHolder extends RecyclerView.ViewHolder{
    TextView repoStarImageView;
    TextView repo_name, repo_language, repo_date;

    public RepoViewHolder(View itemView) {
        super(itemView);

        repoStarImageView = itemView.findViewById(R.id.repo_star);
        repo_name = itemView.findViewById(R.id.repo_name);
        repo_language = itemView.findViewById(R.id.repo_language);
        repo_date = itemView.findViewById(R.id.repo_date);
    }
}
public class RepoListAdapter extends RecyclerView.Adapter<RepoViewHolder>
{
    Response<List<Model>> modelList;

    public RepoListAdapter(Response<List<Model>> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_repo_details, parent, false);

        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.repoStarImageView.setText(String.valueOf(modelList.body().get(position).getStargazersCount()));
        holder.repo_name.setText(modelList.body().get(position).getName());
        holder.repo_language.setText(modelList.body().get(position).getLanguage());
        holder.repo_date.setText(modelList.body().get(position).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return modelList.body().size();
    }
}
