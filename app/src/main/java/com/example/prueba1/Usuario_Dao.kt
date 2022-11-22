package com.example.prueba1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Usuario_Dao {

    @Query("SELECT * FROM Usuario_entidad")
    suspend fun obtenerUsuarios():List<Usuario_Entidad>

    @Query("SELECT * FROM Usuario_Entidad WHERE correo=:correoUsuario")
    suspend fun buscarUsuario(correoUsuario: String): Usuario_Entidad

    @Insert
    suspend fun agregarUsuario(usuario:Usuario_Entidad)

    @Query("Update Usuario_Entidad set telefonoUser=:telef,direccion=:direcc,password=:pass where correo=:correoUsuario")
    suspend fun actualizarUsuario(telef: String, direcc: String, pass: String, correoUsuario: String)

    @Query("DELETE FROM Usuario_Entidad WHERE correo=:correoUsuario")
    suspend fun eliminarUsuario(correoUsuario: String)

}