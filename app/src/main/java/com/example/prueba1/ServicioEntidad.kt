package com.example.prueba1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ServicioEntidad {

    @PrimaryKey
    lateinit var document:String
    lateinit var nombre: String
    lateinit var hClinica: String
    lateinit var origen: String
    lateinit var destino: String
    lateinit var retorna: String
    lateinit var camilleroAsignado: String
    lateinit var estadoServicio: String
    lateinit var tipoTransporte: String
    lateinit var idTransporte: String
    lateinit var fechaServicio: String
    lateinit var horaServicio: String
    lateinit var rutaImagenOrden: String

    constructor(
        document: String,
        nombre: String,
        hClinica: String,
        origen: String,
        destino: String,
        retorna: String,
        camilleroAsignado: String,
        estadoServicio: String,
        tipoTransporte: String,
        idTransporte: String,
        fechaServicio: String,
        horaServicio: String,
        rutaImagenOrden: String
    ) {
        this.document = document
        this.nombre = nombre
        this.hClinica = hClinica
        this.origen = origen
        this.destino = destino
        this.retorna = retorna
        this.camilleroAsignado = camilleroAsignado
        this.estadoServicio = estadoServicio
        this.tipoTransporte = tipoTransporte
        this.idTransporte = idTransporte
        this.fechaServicio = fechaServicio
        this.horaServicio = horaServicio
        this.rutaImagenOrden = rutaImagenOrden
    }
}