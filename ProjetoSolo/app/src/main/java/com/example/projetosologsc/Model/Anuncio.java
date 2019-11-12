package com.example.projetosologsc.Model;

public class Anuncio {
    private String nome;
    private Double preco;
    private String mensagem;
    private Boolean sucesso;

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

    public Anuncio(String nome, Double preco, String mensagem) {
        this.nome = nome;
        this.preco = preco;
        this.mensagem = mensagem;
    }
}
