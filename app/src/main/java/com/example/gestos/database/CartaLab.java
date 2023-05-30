package com.example.gestos.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class CartaLab {

    @SuppressLint("StaticFieldLeak")
    private static CartaLab cartaLab;

    private CartaDAO cartaDAO;

    private CartaLab (Context context) {
        Context appContext = context.getApplicationContext();
        CartaDatabase database = Room.databaseBuilder(appContext, CartaDatabase.class, "carta")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        cartaDAO = database.getCartaDAO();
    }

    public static CartaLab get(Context context) {
        if (cartaLab == null) {
            cartaLab = new CartaLab(context);
        }
        return cartaLab;
    }

    public List<Carta> getAllCartas() { return cartaDAO.getAll(); }

    public List<Carta> getCartasByDificultad(int dificultad) {return cartaDAO.getCartasByDificultad(dificultad);}
    public List<Carta> getCartasByDificultad(int dificultad, int cantidad) {return cartaDAO.getCartasByDificultad(dificultad, cantidad);}

    public List<Carta> getCartasByPalabra(String palabra) {return cartaDAO.getCartasByPalabra(palabra);}

    public void insertAll(List<Carta> cartas) { cartaDAO.insertAll(cartas);}

    public void setIsUsedTrueCartas(List<Carta> cartas) {cartaDAO.updateCartas(cartas);}

    public void setIsUsedFalseAllCartas() {cartaDAO.updateAll();}

    public void delete(Carta carta) {cartaDAO.delete(carta);}
}
