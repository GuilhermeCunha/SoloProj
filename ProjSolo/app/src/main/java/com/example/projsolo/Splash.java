package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projsolo.dbHelper.ConexaoSQLite;
import com.example.projsolo.ui.login.LoginActivity;

import java.util.Objects;

public class Splash extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(getApplicationContext());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTela();
            }
        },2000);



    }

    public void mostrarTela(){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }
}
