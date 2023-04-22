package br.ucs.android.recyclerview2022;

import java.io.Serializable;

public class Filme implements Serializable {

    private int id;
    private int fase;
    private int ordem;
    private String titulo;
    private int ano;

    public Filme() {
    }

    public Filme(int id, int fase, int ordem, String titulo, int ano) {
        this.id = id;
        this.fase = fase;
        this.ordem = ordem;
        this.titulo = titulo;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
