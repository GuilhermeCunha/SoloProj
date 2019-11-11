package com.example.projetosologsc.Interfaces;

import com.example.projetosologsc.Model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NodeServer {
    @FormUrlEncoded
    @POST("/login")
    Call<Usuario> login(@Field("email") String email, @Field("senha") String senha);
}
