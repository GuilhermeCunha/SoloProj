package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CadastrarCliente extends AppCompatActivity implements Organization{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastrar_cliente);
    }

    @Override
    public void reconhecerElementos() {

    }

    @Override
    public void reconhecerListeners() {

    }
}
