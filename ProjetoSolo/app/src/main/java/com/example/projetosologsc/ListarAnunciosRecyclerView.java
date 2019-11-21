package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.DAO.AnuncioDAO;
import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.R;
import com.example.projetosologsc.RecyclerView.AnunciosAdapter;
import java.util.List;
public class ListarAnunciosRecyclerView extends AppCompatActivity implements Organization{
    private RecyclerView rv;
    Button btnVoltar;

    List<Anuncio> anuncios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewanuncios);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv = (RecyclerView) findViewById(R.id.rvAnuncios);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        anuncios = AnuncioDAO.listarAnuncios(getApplicationContext());
        Log.i("ANUNCIOS", "tamanho: " + anuncios.size());
        AnunciosAdapter adapter = new AnunciosAdapter(anuncios);
        rv.setAdapter(adapter);

        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos(){
        this.btnVoltar = findViewById(R.id.btnRVVoltar);
    }
    @Override
    public void reconhecerListeners(){

        this.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
