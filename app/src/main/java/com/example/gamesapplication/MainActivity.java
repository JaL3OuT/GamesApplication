package com.example.gamesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamesapplication.adapter.GamesAdapter;
import com.example.gamesapplication.model.ApiResponse;
import com.example.gamesapplication.retrofit.ApiInterface;
import com.example.gamesapplication.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    Button teams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        ApiService.getRetrofit().create(ApiInterface.class).getGames().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    if (response.body().getData() != null)
                    {
                        Log.e("ListSize", "LIste Size " + response.body().getData().size());
                        GamesAdapter gamesAdapter = new GamesAdapter(response.body().getData());
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        DividerItemDecoration itemDecoration =
                                new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
                        recyclerView.addItemDecoration(itemDecoration);
                        recyclerView.setAdapter(gamesAdapter);
                    }
                }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("throw", "LIste Size " + t);
            }
        });
        teams = findViewById(R.id.buttonEquipe);
        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
                startActivity(intent);
            }
        });
    }
}
