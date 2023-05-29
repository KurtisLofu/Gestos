package com.example.gestos.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartaDAO {

    @Query("SELECT * FROM carta")
    List<Carta> getAll();

    @Query("SELECT * FROM carta where dificultad = :dificultad")
    List<Carta> getCartasByDificultad(int dificultad);

    @Query("SELECT * FROM carta where palabra LIKE '%' || :palabra || '%'")
    List<Carta> getCartasByPalabra(String palabra);

    @Insert
    void insertAll(List<Carta> cartas);

    @Delete
    void delete(Carta carta);
}
