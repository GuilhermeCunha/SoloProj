package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projsolo.Mascaras.CPFMask;

public class CadastroUsuario extends AppCompatActivity implements Organization{
    EditText editCPF;
    Button btnConfirmarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastro_usuario);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.editCPF = (EditText) findViewById(R.id.editCadastroCPF);
        this.editCPF.addTextChangedListener(CPFMask.insert(CPFMask.CPF_MASK, editCPF));
        this.btnConfirmarCadastro = (Button) findViewById(R.id.btnConfirmarCadastroUsuario);
    }

    @Override
    public void reconhecerListeners() {
        this.btnConfirmarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
        });
    }
}
