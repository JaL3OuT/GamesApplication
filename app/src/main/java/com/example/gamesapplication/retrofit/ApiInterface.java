package com.example.gamesapplication.retrofit;

import com.example.gamesapplication.model.ApiResponse;
import com.example.gamesapplication.model.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //endPoint Games
    @GET("/v2/5de8d38a3100000f006b1479")
    Call<ApiResponse> getGames();

    //endPoint Teams
    @GET("/v2/5de8d40d31000074006b1487")
    Call<TeamsResponse> getTeams();


}
