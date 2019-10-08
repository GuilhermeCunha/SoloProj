package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projsolo.Controller.ClienteCTR;
import com.example.projsolo.DAO.ClienteDAO;
import com.example.projsolo.Model.Cliente;
import com.example.projsolo.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

public class ListarClientes extends AppCompatActivity implements Organization{
    ConexaoSQLite conexaoSQLite = new ConexaoSQLite(getApplicationContext());
    ClienteCTR clienteCTR= new ClienteCTR(conexaoSQLite);
    List<Cliente> clientes = new ArrayList<>();

    ListView listaDeCursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listar_clientes);


        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        Cliente a = new Cliente("Guilherme", "71 99271-1726", "4101-7305", "g@gmail.com");
        Cliente b = new Cliente("Gabriel", "71 99271-1726", "4101-7305", "g@gmail.com");

        this.listaDeCursos = (ListView) findViewById(R.id.ListaUsuarios);
        this.clientes = clienteCTR.listarClientes();

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, this.clientes);
        listaDeCursos.setAdapter(adapter);
    }

    @Override
    public void reconhecerListeners() {

    }
}
