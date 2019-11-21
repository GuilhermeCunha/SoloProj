package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetosologsc.DAO.AnuncioDAO;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Anuncio;

import java.util.List;

public class RemoverAnuncio extends AppCompatActivity implements Organization, AdapterView.OnItemSelectedListener {
    Spinner listaAnuncios;
    Button btnRemoverAnuncio;
    Button btnVoltar;
    List<Anuncio> anuncios;
    ArrayAdapter<Anuncio> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_remover_anuncio);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.btnRemoverAnuncio = (Button) findViewById(R.id.btnRemoverAnuncio);
        this.btnVoltar = (Button) findViewById(R.id.btnRemoverAnuncioVoltar);

        this.listaAnuncios = (Spinner) findViewById(R.id.spinnerRemoverAnuncios);
        this.anuncios = AnuncioDAO.listarAnuncios(getApplicationContext());
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, this.anuncios);
//set the spinners adapter to the previously created one.
        this.listaAnuncios.setAdapter(adapter);
        this.listaAnuncios.setOnItemSelectedListener(this);
    }

    @Override
    public void reconhecerListeners() {
        this.btnRemoverAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anuncio anuncioSelecionado = (Anuncio) listaAnuncios.getSelectedItem();
                if(AnuncioDAO.deletarAnuncio(anuncioSelecionado.getID(), getApplicationContext())){
                    adapter.clear();
                    anuncios = AnuncioDAO.listarAnuncios(getApplicationContext());
                    adapter.addAll(anuncios);
                    adapter.notifyDataSetChanged();

                    Toast toast = Toast.makeText(getApplicationContext(), "Anuncio removido com sucesso", Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Anuncio não removido", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        this.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
