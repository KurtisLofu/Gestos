package com.example.gestos.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carta implements Parcelable {
    @PrimaryKey
    @NonNull
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(palabra);
        dest.writeInt(dificultad);
        dest.writeByte((byte) (isUsada ? 1 : 0));
    }

    public static final Creator<Carta> CREATOR = new Creator<Carta>() {
        @Override
        public Carta createFromParcel(Parcel in) {
            return new Carta(in);
        }

        @Override
        public Carta[] newArray(int size) {
            return new Carta[size];
        }
    };

    public Carta(Parcel in) {

        palabra = in.readString();
        dificultad = in.readInt();
        isUsada = in.readByte() != 0;
    }
}
