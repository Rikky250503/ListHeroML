package com.example.heroku.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.heroku.API.APIRequestData;
import com.example.heroku.API.RetroServer;
import com.example.heroku.Model.ModelResponse;
import com.example.heroku.R;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    private  EditText etNama, etRole, etLane, etTahun_rilis, etDes_hero, etSkill1, etDes1, etSkill2, etDes2, etSkill3, etDes3,etFoto;
    private Button btnTambah;

    private String nama,role,lane,tahun_rilis,des_hero,skill1,des1,skill2,des2,skill3,des3,foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama= findViewById(R.id.et_tambahNamaHero);
        etRole = findViewById(R.id.et_tambahRole);
        etLane = findViewById(R.id.et_tambahLane);
        etTahun_rilis = findViewById(R.id.et_tambahTahunRilis);
        etDes_hero = findViewById(R.id.et_tambahDesHero);
        etSkill1 = findViewById(R.id.et_tambahSkill1);
        etDes1 = findViewById(R.id.et_tambahDes1);
        etSkill2 = findViewById(R.id.et_tambahSkill2);
        etDes2 = findViewById(R.id.et_tambahDes2);
        etSkill3 = findViewById(R.id.et_tambahSkill3);
        etDes3 = findViewById(R.id.et_tambahDes3);
        etFoto = findViewById(R.id.et_tambahFoto);
        btnTambah = findViewById(R.id.btn_Tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = etNama.getText().toString();
                role = etRole.getText().toString();
                lane = etLane.getText().toString();
                tahun_rilis= etTahun_rilis.getText().toString();
                des_hero = etDes_hero.getText().toString();
                skill1 = etSkill1.getText().toString();
                des1 = etDes1.getText().toString();
                skill2 = etSkill2.getText().toString();
                des2 = etDes2.getText().toString();
                skill3 = etSkill3.getText().toString();
                des3 = etDes3.getText().toString();
                foto = etFoto.getText().toString();

                if(nama.trim().isEmpty()){
                    etNama.setError("Nama Tidak boleh Kosong");
                }
                else if(role.trim().isEmpty()){
                    etRole.setError("Role Tidak Boleh Kosong");
                }
                else if(lane.trim().isEmpty()){
                    etLane.setError("Lane Tidak Boleh Kosong");
                }
                else if(tahun_rilis.trim().isEmpty()){
                    etTahun_rilis.setError("Tahun Tidak Boleh Kosong");
                }
                else if(des_hero.trim().isEmpty()){
                    etDes_hero.setError("Deskirpsi Hero Tidak Boleh Kosong");
                }
                else if(skill1.trim().isEmpty()){
                    etSkill1.setError("Skill 1 Tidak Boleh Kosong");
                }
                else if(des1.trim().isEmpty()){
                    etDes1.setError("Des 1 Tidak Boleh Kosong");
                }
                else if(skill2.trim().isEmpty()){
                    etSkill2.setError("Skill 2 Tidak Boleh Kosong");
                }
                else if(des2.trim().isEmpty()){
                    etDes2.setError("Des 2Tidak Boleh Kosong");
                }
                else if(skill3.trim().isEmpty()){
                    etSkill3.setError("Skill 3 Tidak Boleh Kosong");
                }
                else if(des3.trim().isEmpty()){
                    etDes3.setError("Des 3 Tidak Boleh Kosong");
                }
                else if(foto.trim().isEmpty()){
                    etFoto.setError("Link foto Tidak Boleh Kosong");
                }
                else {
                    tambahHero();
                }
            }
        });
    }
    private  void  tambahHero(){
        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardCreate(nama,role,lane,tahun_rilis,des_hero,skill1,des1,skill2,des2,skill3,des3,foto);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this,"kode: "+ kode +",Pesan:"+ pesan,Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(TambahActivity.this,"Gagal Menghubungi Server: " +t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}