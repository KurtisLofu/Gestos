package com.example.gestos.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface CartaDAO {

    @Query("SELECT * FROM carta")
    List<Carta> getAll();

    @Query("SELECT * FROM carta where dificultad = :dificultad")
    List<Carta> getCartasByDificultad(int dificultad);

    @Query("SELECT * FROM carta where dificultad = :dificultad and isUsada = 0 order by RANDOM() limit :cantidad")
    List<Carta> getCartasByDificultad(int dificultad, int cantidad);

    @Query("SELECT * FROM carta where palabra LIKE '%' || :palabra || '%'")
    List<Carta> getCartasByPalabra(String palabra);

    @Upsert
    void insertAll(List<Carta> cartas);

    @Query("UPDATE carta set isUsada = 0")
    void updateAll();

    @Update
    void updateCartas(List<Carta> cartas);

    @Delete
    void delete(Carta carta);
}
