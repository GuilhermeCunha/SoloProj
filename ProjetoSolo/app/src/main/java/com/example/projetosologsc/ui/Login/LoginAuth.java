package com.example.projetosologsc.ui.Login;

import android.util.Log;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Model.Usuario;

import org.w3c.dom.Node;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAuth {
    public static boolean login(String email, String senha){
        NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
        Call<Usuario> call = service.login(email, senha);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.e("ONRESPONSE","OK");
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("OSFAILURE", "NÃO OK");
                Log.e("ERROR", t.getMessage());
            }
        });
        return true;
    }
}
