package com.example.projetosologsc.Model;

public class Usuario {
    private String email;
    private String senha;
    private String celular;
    private String nome;
    private Boolean sucesso;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public Usuario(String email, String senha, String celular, String nome) {
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.nome = nome;
    }
}
