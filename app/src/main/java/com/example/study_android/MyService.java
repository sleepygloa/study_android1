package com.example.study_android;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyService {

    //https://api.github.com/users/{users}/repos

    @GET("users/{user}/repos")
    Call<JsonArray> getUseRepositories(@Path("user") String userName);

    @FormUrlEncoded
    @POST("users/repost")
    Call<JsonArray> postUser(@Field("userName") String name, @Field("age") int age);

}
