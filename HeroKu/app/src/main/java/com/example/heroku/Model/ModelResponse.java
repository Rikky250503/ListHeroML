package com.example.heroku.Model;

import java.util.List;

public class ModelResponse {

    private  String kode,pesan;

    private List<ModelHero> data;

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }

    public List<ModelHero> getData() {
        return data;
    }
}
