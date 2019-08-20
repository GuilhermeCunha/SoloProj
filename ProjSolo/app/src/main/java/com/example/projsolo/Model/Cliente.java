package com.example.projsolo.Model;

public class Cliente {
    private int id;
    private String nome;
    private String celular;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String celular, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
