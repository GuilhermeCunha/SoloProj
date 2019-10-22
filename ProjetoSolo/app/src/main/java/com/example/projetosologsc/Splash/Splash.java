package com.example.projetosologsc.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Login;
import com.example.projetosologsc.R;

public class Splash extends AppCompatActivity implements Organization {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTela();
            }
        },2000);
    }
    public void mostrarTela(){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }

    @Override
    public void reconhecerElementos() {

    }

    @Override
    public void reconhecerListeners() {

    }
}
