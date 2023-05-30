package com.example.gestos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Carta.class}, version = 3)
public abstract class CartaDatabase  extends RoomDatabase {
    public abstract CartaDAO getCartaDAO();
}
