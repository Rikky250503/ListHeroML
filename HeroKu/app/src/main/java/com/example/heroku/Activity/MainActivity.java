package com.example.heroku.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.heroku.API.APIRequestData;
import com.example.heroku.API.RetroServer;

import com.example.heroku.Adapter.AdapterHero;
import com.example.heroku.Model.ModelHero;
import com.example.heroku.Model.ModelResponse;
import com.example.heroku.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHero;
    private FloatingActionButton fabTambah;
    private ProgressBar pbHero;
    private RecyclerView.Adapter adHero;
    private RecyclerView.LayoutManager lmHero;
    private List<ModelHero> listHero = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.rv_heroku);
        fabTambah = findViewById(R.id.fab_tambah);
        pbHero = findViewById(R.id.pb_heroku);

        lmHero = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvHero.setLayoutManager(lmHero);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TambahActivity.class));
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        retrieveHeroku();
    }
    public void retrieveHeroku(){
        pbHero.setVisibility(View.VISIBLE);

        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardRetrieve();

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listHero = response.body().getData();

                adHero = new AdapterHero(MainActivity.this, listHero);
                rvHero.setAdapter(adHero);
                adHero.notifyDataSetChanged();
                pbHero.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
                pbHero.setVisibility(View.GONE);
            }
        });
    }

}