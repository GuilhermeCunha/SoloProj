package com.example.projsolo.Controller;

import com.example.projsolo.DAO.ClienteDAO;
import com.example.projsolo.Model.Cliente;
import com.example.projsolo.dbHelper.ConexaoSQLite;

import java.util.List;

public class ClienteCTR {
    private static String TAG = "ClienteController";
    private final ClienteDAO clienteDAO;

    public ClienteCTR(ConexaoSQLite conexaoSQLite) {
        this.clienteDAO = new ClienteDAO(conexaoSQLite);
    }

    public boolean salvarCliente(Cliente c){
        return this.clienteDAO.salvarCliente(c);
    }

    public List<Cliente> listarClientes(){
        return this.clienteDAO.listarClientes();
    }

    public boolean apagarCliente(Cliente c){
        return this.clienteDAO.apagarCliente(c);
    }

    public boolean editarCliente(Cliente c){
        return this.clienteDAO.editarCliente(c);
    }

}
