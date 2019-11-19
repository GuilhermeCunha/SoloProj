package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements Organization {
    EditText editEmail;
    EditText editNome;
    EditText editCelular;
    EditText editSenha;
    EditText editCPF;
    Button btnRegisterCriar;
    Button btnRegisterVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.editEmail = (EditText) findViewById(R.id.editRegisterEmail);
        this.editCelular = (EditText) findViewById(R.id.editRegisterCelular);
        this.editNome = (EditText) findViewById(R.id.editRegisterNome);
        this.editSenha = (EditText) findViewById(R.id.editRegisterSenha);
        this.editCPF = (EditText) findViewById(R.id.editRegisterCPF);
        this.btnRegisterVoltar = (Button) findViewById(R.id.btnRegisterVoltar);
        this.btnRegisterCriar = (Button) findViewById(R.id.btnRegisterCriar);
    }

    @Override
    public void reconhecerListeners() {
        this.btnRegisterVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.btnRegisterCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  editEmail.getText().toString();
                String nome =  editNome.getText().toString();
                String celular =  editCelular.getText().toString();
                String senha =  editSenha.getText().toString();
                String CPF =  editCPF.getText().toString();

                Usuario usuario = new Usuario(email, senha, celular, nome, CPF);
                Log.i("PRINT", usuario.getNome());

                NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
                Call<Usuario> call = service.criarUsuario(email, nome, senha, celular, CPF);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            Log.i("PRINT", "Criado");

                            Intent returnIntent = new Intent();
                            returnIntent.putExtra("nome",nome);
                            setResult(Activity.RESULT_OK,returnIntent);
                            finish();
                        }else{
                            Log.i("PRINT", "NÃO Criado");
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("CriarUsuario", t.getMessage());
                    }
                });
            }
        });
    }
}
