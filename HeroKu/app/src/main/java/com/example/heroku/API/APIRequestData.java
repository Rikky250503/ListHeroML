package com.example.heroku.API;

import com.example.heroku.Model.ModelHero;
import com.example.heroku.Model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {

    @GET("retrieve.php")
    Call<ModelResponse> ardRetrieve();

    @FormUrlEncoded
    @POST("create.php")
    Call<ModelResponse> ardCreate(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("role") String role,
            @Field("lane") String lane,
            @Field("tahun_rilis") String tahun_rilis,
            @Field("des_hero") String des_hero,
            @Field("skill1") String skill1,
            @Field("des1") String des1,
            @Field("skill2") String skill2,
            @Field("des2") String des2,
            @Field("skill3") String skill3,
            @Field("des3") String des3,
            @Field("foto") String foto
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ModelResponse> ardUpdate(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("role") String role,
            @Field("lane") String lane,
            @Field("tahun_rilis") String tahun_rilis,
            @Field("des_hero") String des_hero,
            @Field("skill1") String skill1,
            @Field("des1") String des1,
            @Field("skill2") String skill2,
            @Field("des2") String des2,
            @Field("skill3") String skill3,
            @Field("des3") String des3,
            @Field("foto") String foto
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ModelHero> ardDelete(
            @Field("id") String id);
}
