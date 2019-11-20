package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.projetosologsc.Interfaces.Organization;

public class Menu extends AppCompatActivity implements Organization {
    Button btnListarProdutos;
    Button btnCadastrarAnuncios;
    Button btnListarAnunciosRecycle;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(getString(R.string.pref_email), "");
        Log.i("PRINT", "LOGADO COMO " + email);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.btnListarProdutos = (Button) findViewById(R.id.btnMenuListarProdutos);
        this.btnCadastrarAnuncios = (Button) findViewById(R.id.btnMenuCadastrarProduto);
        this.btnListarAnunciosRecycle = (Button) findViewById(R.id.btnListarAnunciosRecycle);
    }

    @Override
    public void reconhecerListeners() {
        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListarAnuncios.class);
                startActivity(i);
            }
        });

        this.btnCadastrarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrarAnuncio.class);
                startActivity(i);
            }
        });
        this.btnListarAnunciosRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarAnunciosRecyclerView.class);
                startActivity(i);
            }
        });
    }
}
