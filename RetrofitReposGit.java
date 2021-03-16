package com.example.tarea1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitReposGit {

    private static Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    private static IServicioRepos servicio;

    public static IServicioRepos getServicio() {
        if (servicio == null)
            servicio = retrofit.create(IServicioRepos.class);
        return servicio;
    }
}
