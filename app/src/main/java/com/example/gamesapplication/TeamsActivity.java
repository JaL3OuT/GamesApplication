package com.example.gamesapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamesapplication.adapter.TeamAdapter;
import com.example.gamesapplication.model.TeamsResponse;
import com.example.gamesapplication.retrofit.ApiInterface;
import com.example.gamesapplication.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        recyclerView = findViewById(R.id.recyclerTeam);
        ApiService.getRetrofit().create(ApiInterface.class).getTeams().enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getData() != null) {
                        TeamAdapter teamAdapter = new TeamAdapter(response.body().getData());
                        recyclerView.setLayoutManager(new LinearLayoutManager(TeamsActivity.this));
                        DividerItemDecoration itemDecoration =
                                new DividerItemDecoration(TeamsActivity.this, DividerItemDecoration.VERTICAL);
                        // recyclerView.addItemDecoration(itemDecoration);
                        recyclerView.setAdapter(teamAdapter);
                    }

                }

            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                Log.e("throw", t.getMessage());
            }
        });

    }
}
