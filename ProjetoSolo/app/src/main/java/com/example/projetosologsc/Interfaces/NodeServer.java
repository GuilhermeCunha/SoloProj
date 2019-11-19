package com.example.projetosologsc.Interfaces;

import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface NodeServer {
    @FormUrlEncoded
    @POST("/login")
    Call<Usuario> login(@Field("email") String email, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("/criar-usuario")
    Call<Usuario> criarUsuario (@Field("email") String email, @Field("nome") String nome, @Field("senha") String senha, @Field("celular") String celular, @Field("cpf") String cpf);

    @FormUrlEncoded
    @PUT("/editar-usuario")
    Call<Usuario> EditarUsuario (@Field("email") String email, @Field("nome") String nome, @Field("senha") String senha, @Field("celular") String celular, @Field("cpf") String cpf);

    @FormUrlEncoded
    @DELETE("/remover-usuario")
    Call<Usuario> RemoverUsuario (@Field("email") String email);

    @GET("/listar-anuncios")
    Call<List<Anuncio>> ListarAnuncios ();

    @FormUrlEncoded
    @POST("/criar-anuncio")
    Call<Anuncio> CriarAnuncio (@Field("id") String id, @Field("nome") String nome, @Field("preco") String preco, @Field("mensagem") String mensagem);

    @FormUrlEncoded
    @PUT("/editar-anuncio")
    Call<Anuncio> EditarAnuncio (@Field("id") String id, @Field("nome") String nome, @Field("preco") String preco, @Field("mensagem") String mensagem);

    @FormUrlEncoded
    @DELETE("/remover-anuncio")
    Call<Anuncio> RemoverAnuncio (@Field("id") String id);

}
