package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projsolo.Fragment.ClienteListFragment;

public class GerenciarClientes extends AppCompatActivity implements Organization{
    Button cadastrarClientes;
    Button editarClientes;
    Button listarClientes;
    Button apagarClientes;
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
        this.editarClientes = (Button) findViewById(R.id.btnEditarCliente);
        this.listarClientes = (Button) findViewById(R.id.btnListarCllientes);
        this.apagarClientes = (Button) findViewById(R.id.btnApagarCliente);


    }

    @Override
    public void reconhecerListeners() {
        this.cadastrarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GerenciarClientes.this, CadastrarCliente.class);
                startActivity(i);
            }
        });

        this.editarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        this.listarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent i = new Intent(getApplicationContext(), ListarClientes.class);
                startActivity(i);
                 */
                Intent i = new Intent(getApplicationContext(), ListarClientesFragment.class);
                startActivity(i);

            }
        });
        this.apagarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
