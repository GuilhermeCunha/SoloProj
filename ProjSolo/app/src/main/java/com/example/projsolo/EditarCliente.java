package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditarCliente extends AppCompatActivity implements Organization{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_editar_cliente);
    }

    @Override
    public void reconhecerElementos() {

    }

    @Override
    public void reconhecerListeners() {

    }
}
