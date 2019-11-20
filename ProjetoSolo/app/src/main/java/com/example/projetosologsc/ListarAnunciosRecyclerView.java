package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.DAO.AnuncioDAO;
import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.R;
import com.example.projetosologsc.RecyclerView.AnunciosAdapter;
import java.util.List;
public class ListarAnunciosRecyclerView extends AppCompatActivity implements Organization{
    RecyclerView rv;
    LinearLayoutManager llm;
    List<Anuncio> anuncios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_anuncios_recycler_view);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos(){
        this.rv = (RecyclerView) findViewById(R.id.rvAnuncios);
        //this.rv.setHasFixedSize(true);
        this.rv.setLayoutManager(this.llm);
        AnunciosAdapter adapter = new AnunciosAdapter(this.anuncios);
        this.rv.setAdapter(adapter);
        this.llm = new LinearLayoutManager(getApplicationContext());
        this.anuncios = AnuncioDAO.listarAnuncios(getApplicationContext());
    }
    @Override
    public void reconhecerListeners(){



    }
}
