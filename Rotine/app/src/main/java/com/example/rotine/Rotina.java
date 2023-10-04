package com.example.rotine;

import android.widget.ImageView;

public class Rotina {

    private String nome;
    private String horario;
//    private ImageView icon;

    public Rotina(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Rotina{" +
                "nome='" + nome + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
