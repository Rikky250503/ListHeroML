package com.example.heroku.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.heroku.Model.ModelHero;
import com.example.heroku.R;

public class DetailActivity extends AppCompatActivity {

    private TextView  tvNama, tvRole, tvLane, tvTahun_rilis, tvDes_hero, tvSkill1, tvDes1, tvSkill2, tvDes2, tvSkill3, tvDes3;
    private ImageView ivFotoDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        tvNama= findViewById(R.id.tv_Nama2);
        tvRole = findViewById(R.id.tv_Role2);
        tvLane = findViewById(R.id.tv_Lane2);
        tvTahun_rilis = findViewById(R.id.tv_tahun_rilis2);
        tvDes_hero = findViewById(R.id.tv_isiDes);
        tvSkill1 = findViewById(R.id.tv_namaSkill1);
        tvDes1 = findViewById(R.id.tv_isiDesSkill1);
        tvSkill2 = findViewById(R.id.tv_namaSkill2);
        tvDes2 = findViewById(R.id.tv_isiDesSkill2);
        tvSkill3 = findViewById(R.id.tv_namaSkill3);
        tvDes3 = findViewById(R.id.tv_isiDesSkill3);
        ivFotoDetail = findViewById(R.id.iv_foto_detail);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("varNama");
        String role = intent.getStringExtra("varRole");
        String lane = intent.getStringExtra("varLane");
        String tahun_rilis =intent.getStringExtra("varTahun_rilis");
        String des_hero = intent.getStringExtra("varDes_hero");
        String skill1 = intent.getStringExtra("varSkill1");
        String des1 = intent.getStringExtra("varDes1");
        String skill2 = intent.getStringExtra("varSkill2");
        String des2 = intent.getStringExtra("varDes2");
        String skill3 = intent.getStringExtra("varSkill3");
        String des3 = intent.getStringExtra("varDes3");
        String foto = getIntent().getStringExtra("varFoto");
//        if (foto != null) {
//            ImageView imageView = findViewById(R.id.iv_foto_detail);
//            Glide.with(this).load(foto).into(imageView);
//        }
//        else{
//           String foto1 = modelHero.getFoto();
//           ImageView imageView1 = findViewById(R.id.iv_foto_detail);
//           Glide.with(this).load(foto1).into(imageView1);
//        }

        tvNama.setText(nama);
        tvRole.setText(role);
        tvLane.setText(lane);
        tvTahun_rilis.setText(tahun_rilis);
        tvDes_hero.setText(des_hero);
        tvSkill1.setText(skill1);
        tvDes1.setText(des1);
        tvSkill2.setText(skill2);
        tvDes2.setText(des2);
        tvSkill3.setText(skill3);
        tvDes3.setText(des3);


    }
}