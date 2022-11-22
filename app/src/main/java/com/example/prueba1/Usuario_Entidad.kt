package com.example.prueba1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario_Entidad {

    @PrimaryKey
    lateinit var correo: String
    lateinit var nombre: String
    lateinit var apellidos: String
    lateinit var telefonoUser: String
    lateinit var direccion: String
    lateinit var password:String

    constructor(
        correo: String,
        nombre: String,
        apellidos: String,
        telefonoUser: String,
        direccion: String,
        password: String
    ) {
        this.correo = correo
        this.nombre = nombre
        this.apellidos = apellidos
        this.telefonoUser = telefonoUser
        this.direccion = direccion
        this.password = password
    }


}