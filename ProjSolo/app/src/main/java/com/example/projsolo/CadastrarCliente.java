package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projsolo.Controller.ClienteCTR;
import com.example.projsolo.Model.Cliente;
import com.example.projsolo.dbHelper.ConexaoSQLite;

public class CadastrarCliente extends AppCompatActivity implements Organization{
    ConexaoSQLite conexaoSQLite;
    ClienteCTR clienteCTR;
    EditText nomeCompleto;
    EditText celular;
    EditText telefone;
    EditText email;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastrar_cliente);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.nomeCompleto = (EditText) findViewById(R.id.editCadastroNomeCliente);
        this.celular = (EditText) findViewById(R.id.editCadastroCelularCliente);
        this.telefone = (EditText) findViewById(R.id.editCadastroTelefoneCliente);
        this.email = (EditText) findViewById(R.id.editCadastroEmailCliente);
        this.cadastrar = (Button) findViewById(R.id.btnConfirmarCadastroCliente);
        this.conexaoSQLite = new ConexaoSQLite(getApplicationContext());
        this.clienteCTR = new ClienteCTR(conexaoSQLite);

    }

    @Override
    public void reconhecerListeners() {
        this.cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNome = nomeCompleto.getText().toString();
                String strCelular = celular.getText().toString();
                String strTelefone = telefone.getText().toString();
                String strEmail = email.getText().toString();

                Cliente cliente = new Cliente(strNome, strCelular, strTelefone, strEmail);
                clienteCTR.salvarCliente(cliente);
                Intent i = new Intent(getApplicationContext(), GerenciarClientes.class);
                startActivity(i);

                /*
                Intent i = new Intent(getApplicationContext(), UsuarioFoiCadastrado.class);
                i.putExtra("Cliente", cliente);
                startActivity(i);
                */
            }
        });
    }
}
