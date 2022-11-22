package com.example.prueba1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities= [ServicioEntidad::class],
    version = 1
)
abstract class bdServicios: RoomDatabase() {

    abstract fun daoServicio(): ServicioDao
}