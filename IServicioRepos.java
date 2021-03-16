package com.example.tarea1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServicioRepos {
        @GET("{username}/repos")
        Call<List<Repo>> searchRepos(@Path("username") String username,
                                     @Query("api_key") String api_key);
}
