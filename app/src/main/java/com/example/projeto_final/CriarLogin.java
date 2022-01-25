package com.example.projeto_final;

import java.io.Serializable;

public class CriarLogin implements Serializable {
    String nome, pass, cargo;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CriarLogin() {

    }

    public CriarLogin(String nome, String pass, String cargo) {
        this.nome = nome;
        this.pass = pass;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
