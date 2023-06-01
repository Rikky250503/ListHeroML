package com.example.heroku.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.heroku.Model.ModelHero;
import com.example.heroku.R;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private List<ModelHero> listhero;

    private TextView  tvId, tvNama, tvRole, tvLane, tvTahun_rilis, tvDes_hero, tvSkill1, tvDes1, tvSkill2, tvDes2, tvSkill3, tvDes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}