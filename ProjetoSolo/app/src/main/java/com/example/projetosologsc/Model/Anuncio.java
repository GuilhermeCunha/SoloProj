package com.example.projetosologsc.Model;

public class Anuncio {
    private int ID;
    private String nome;
    private Double preco;
    private String mensagem;
    private Boolean sucesso;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public Anuncio(int ID, String nome, String mensagem, Double preco) {
        this.ID = ID;
        this.nome = nome;
        this.preco = preco;
        this.mensagem = mensagem;
    }

    public Anuncio(String nome, String mensagem, Double preco) {
        this.nome = nome;
        this.preco = preco;
        this.mensagem = mensagem;
    }
}
