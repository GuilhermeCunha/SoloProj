package com.example.projsolo.Fragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.projsolo.Model.Cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ClienteListFragment extends ListFragment {
    List<Cliente> clientes;
    ArrayAdapter<Cliente> adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        clientes = carregarClientes();
        adapter = new ArrayAdapter<Cliente>(getActivity(), android.R.layout.simple_list_item_1, clientes);
        setListAdapter(adapter);
    }

    private List<Cliente> carregarClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente( "Guilherme", "992711726", "41017305", "Guiscunha@gmail.com"));
        clientes.add(new Cliente( "Gabriel", "991141235", "41017305", "Guiscunha@gmail.com"));
    return clientes;
    }
}
