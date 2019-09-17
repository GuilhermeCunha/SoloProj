package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GerenciarClientes extends AppCompatActivity implements Organization{
    Button cadastrarClientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gerenciar_clientes);

        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.cadastrarClientes = (Button) findViewById(R.id.btnCadastrarCliente);

    }

    @Override
    public void reconhecerListeners() {
        this.cadastrarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastrarCliente.class);
                startActivity(i);
            }
        });

    }
}
