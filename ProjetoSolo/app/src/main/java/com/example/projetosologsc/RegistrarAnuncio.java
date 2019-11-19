package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.DAO.AnuncioDAO;
import com.example.projetosologsc.FuncoesEstaticas.FuncoesEstaticas;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.Model.Usuario;

import retrofit2.Call;

public class RegistrarAnuncio extends AppCompatActivity implements Organization {

    EditText editNome;
    EditText editPreco;
    EditText editMensagem;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registrar_anuncio);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.editNome = (EditText) findViewById(R.id.editRegistrarAnuncioNome);
        this.editPreco = (EditText) findViewById(R.id.editRegistrarAnuncioPreco);
        this.editMensagem = (EditText) findViewById(R.id.editRegistrarAnuncioMensagem);
        this.btnCadastrar = (Button) findViewById(R.id.btnRegistrarAnuncio);
    }

    @Override
    public void reconhecerListeners() {
        this.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!FuncoesEstaticas.isConnected(getApplicationContext())){
                    Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                String nome = editNome.getText().toString();
                Double preco = Double.parseDouble(editPreco.getText().toString());
                String mensagem = editMensagem.getText().toString();
                Anuncio anuncio = new Anuncio(nome ,mensagem, preco);
                Boolean sucesso = AnuncioDAO.inserirAnuncio(anuncio, getApplicationContext());
                if(sucesso){
                    Log.i("RESPOSTA", "Criado com sucesso");
                    Toast toast = Toast.makeText(getApplicationContext(), "Anuncio cadastrado com sucesso", Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Log.i("RESPOSTA", "Não foi criado com sucesso");
                }
            }
        });
    }
}
