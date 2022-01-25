package com.example.projeto_final;

import java.io.Serializable;

public class Compras implements Serializable {
    String marca, modelos, ano, tiposwap;

    public Compras(String marca, String modelos, String ano, String tiposwap) {
        this.marca = marca;
        this.modelos = modelos;
        this.ano = ano;
        this.tiposwap = tiposwap;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelos() {
        return modelos;
    }

    public void setModelos(String modelos) {
        this.modelos = modelos;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTiposwap() {
        return tiposwap;
    }

    public void setTiposwap(String tiposwap) {
        this.tiposwap = tiposwap;
    }

}
