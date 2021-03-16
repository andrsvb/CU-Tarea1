package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button boton;
    EditText username;
    TextView busqueda;
    List<Repo> repos;
    IServicioRepos servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.buttonBuscar);
        username = (EditText) findViewById(R.id.textInputUsername);
        busqueda = (TextView) findViewById(R.id.textView);
    }

    public void buscar(View view) {
        if(username.getText().toString().isEmpty());
        else {
            servicio = RetrofitReposGit.getServicio();
            String name = username.getText().toString();
            Call<List<Repo>> call = servicio.searchRepos(name, getString(R.string.api_key));
            call.enqueue(new Callback<List<Repo>>() {

                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    String str;
                    repos = response.body();
                    if(repos == null){
                        busqueda.setText("No hay repos");
                    } else {
                        str = "";
                        for (int i = 0; i < repos.size(); i++)
                            str = str + repos.get(i).toString();
                        busqueda.setText(str);
                    }
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    busqueda.setText("Error de búsqueda");
                }
            });
        }
    }
}
