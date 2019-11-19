package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.DAO.AnuncioDAO;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarAnuncios extends AppCompatActivity implements Organization {
    List<Anuncio> anuncios;
    ListView listview;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listar_produtos);
        reconhecerElementos();
        reconhecerListeners();


    }

    @Override
    public void reconhecerElementos() {
        this.listview = (ListView) findViewById(R.id.listAnuncios);
        this.anuncios = AnuncioDAO.listarAnuncios(getApplicationContext());
        List<String> nomeAnuncios = new ArrayList<>();

        for(int i=0; i<this.anuncios.size();i++){
            nomeAnuncios.add(this.anuncios.get(i).getNome());
        }
        Log.i("PRINT", "Tamanho: " + this.anuncios.size());
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomeAnuncios);
        this.listview.setAdapter(this.adapter);
    }

    @Override
    public void reconhecerListeners() {


        /*
        NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
        Call<List<Anuncio>> call = service.ListarAnuncios();
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                if (response.isSuccessful()){
                    Log.i("PRINT", Integer.toString(response.body().size()));
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                    Log.e("OnFailure", t.getMessage().toString());
            }
        });*/
    }
}
