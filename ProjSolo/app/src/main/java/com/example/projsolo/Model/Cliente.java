package com.example.projsolo.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
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
    public Cliente( String nome, String celular, String telefone, String email) {
        this.nome = nome;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
    }


    protected Cliente(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        celular = in.readString();
        telefone = in.readString();
        email = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(celular);
        parcel.writeString(telefone);
        parcel.writeString(email);
    }
}
