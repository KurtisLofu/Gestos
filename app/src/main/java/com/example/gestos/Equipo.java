package com.example.gestos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Equipo implements Parcelable {

    public String nombre;
    public int puntos;
    public boolean isTurno;

    public boolean isTurno() {
        return isTurno;
    }

    public void setTurno(boolean turno) {
        isTurno = turno;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(puntos);
        parcel.writeByte((byte) (isTurno ? 1 : 0));
    }


    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };

    public Equipo(Parcel in) {

        nombre = in.readString();
        puntos = in.readInt();
        isTurno = in.readByte() != 0;
    }
}
