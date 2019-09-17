package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.projsolo.Model.Cliente;

public class UsuarioFoiCadastrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_usuario_foi_cadastrado);

        Cliente c = getIntent().getExtras().getParcelable("Cliente");
        Log.i("USUARIO", c.getNome() + c.getCelular() + c.getTelefone() + c.getEmail());
    }
}
