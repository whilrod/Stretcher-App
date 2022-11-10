package com.example.prueba1


import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.core.net.toUri

import androidx.recyclerview.widget.RecyclerView

class RecylerCamillero(val listaCamilleros:MutableList<Camillero>):RecyclerView.Adapter<RecylerCamillero.MiHolder>() {

    inner class MiHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        lateinit var nombre:TextView
        lateinit var telefono:TextView
        lateinit var estado:TextView
        lateinit var calificacion:TextView
        lateinit var foto:ImageView
        lateinit var fotoEstado:ImageView
        init{
            nombre=itemview.findViewById(R.id.nombreCamillero)
            telefono=itemview.findViewById(R.id.telefonoCamillero)
            estado=itemview.findViewById(R.id.estado)
            calificacion=itemview.findViewById(R.id.calificacion1)
            foto=itemview.findViewById(R.id.fotocamilleros)
            fotoEstado=itemview.findViewById(R.id.imagenEstado)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {

        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.card_camillero,parent,false)
        return MiHolder(itemView)
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {

        var camillero =listaCamilleros[position]
        holder.nombre.text=camillero.nombre
        holder.telefono.text=camillero.telefono
        holder.estado.text= camillero.estado.toString()
        if(holder.estado.text=="true"){
            holder.estado.setTextColor(Color.parseColor("#67FB34"))
            holder.estado.text="ACTIVO"
            holder.fotoEstado.setImageResource(R.drawable.ic_baseline_person_24_verde)
        }else{
            holder.estado.text="INACTIVO"
        }
        holder.foto.setImageResource(camillero.foto.toInt()) //imagen en drawable
        holder.calificacion.text= camillero.calificacion.toString()


    }



    override fun getItemCount(): Int {
        return listaCamilleros.size
    }
}