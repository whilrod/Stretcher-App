package com.example.prueba1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ServicioDao {

    @Query("SELECT * FROM ServicioEntidad")
    suspend fun obtenerServicio():List<ServicioEntidad>

    @Query("SELECT * FROM ServicioEntidad WHERE document=:docuServicio")
    suspend fun buscaServicio(docuServicio: String): ServicioEntidad

    @Insert
    suspend fun agregarServicio(servicio:ServicioEntidad)

    @Query("Update ServicioEntidad set destino=:destinoServicio,retorna=:retornaServicio,camilleroAsignado=:camiAsignado where document=:docuServicio")
    suspend fun actualizarServicio(destinoServicio: String, retornaServicio: String, camiAsignado: String, docuServicio: String)

    @Query("DELETE FROM ServicioEntidad WHERE document=:docuServicio")
    suspend fun eliminarServicio(docuServicio: String)
}