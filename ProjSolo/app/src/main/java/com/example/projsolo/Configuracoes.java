package com.example.projsolo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Configuracoes extends AppCompatActivity implements Organization{

    ImageButton imgbtnAlterarLinguagem;
    TextView txtLinguagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_configuracoes);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.imgbtnAlterarLinguagem = (ImageButton) findViewById(R.id.imgbtnAlterarLinguagem);
        this.txtLinguagem = (TextView) findViewById(R.id.txtLinguagem);
    }

    @Override
    public void reconhecerListeners() {
        this.imgbtnAlterarLinguagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("CLICK", "BOTAO CLICADO");
                Intent i = new Intent(getApplicationContext(), SelecionarLinguagem.class);
                i.putExtra("LinguaSelecionada", txtLinguagem.getText().toString());
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Verfica se o requestCode é o mesmo que foi passado
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            String message =data.getStringExtra("MESSAGE");
            Log.i("OnActivityResult", "Valor retornado : " + message);
            txtLinguagem.setText(message);
        }
    }
}
