package com.example.gestos.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carta {
    @PrimaryKey
    public String palabra;

    @ColumnInfo(name = "dificultad")
    public int dificultad;

    public boolean isUsada;

    public boolean isUsada() {
        return isUsada;
    }

    public void setUsada(boolean usada) {
        isUsada = usada;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Carta(String palabra, int dificultad) {
        this.palabra = palabra;
        this.dificultad = dificultad;
    }

    public Carta() {
    }
}
