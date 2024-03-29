package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements Organization{
    //Elementos
    Button btnGerenciarClientes;
    Button btnConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        reconhecerElementos();
        reconhecerListeners();
    }


    public void reconhecerElementos(){
        this.btnGerenciarClientes = (Button) findViewById(R.id.btnGerenciarClientes);
        this.btnConfiguracoes = (Button) findViewById(R.id.btnConfiguracoes);

    }

    public void reconhecerListeners(){

        this.btnGerenciarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GerenciarClientes.class);
                startActivity(i);
            }
        });

        this.btnConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Configuracoes.class);
                startActivity(i);
            }
        });

    }
}
