package com.example.prueba1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerServicio(val listaServicios: MutableList<Servicios>):RecyclerView.Adapter<RecyclerServicio.MiHolder>() {
    inner class MiHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        lateinit var documento:TextView
        lateinit var hClinica:TextView
        lateinit var nombres:TextView
        lateinit var origen:TextView
        lateinit var destino:TextView
        lateinit var recomendaciones:TextView
        //lateinit var status:TextView
       // lateinit var fotoServicio: TextView
        init {
            documento=itemview.findViewById(R.id.serv_documento)
            hClinica=itemview.findViewById(R.id.serv_hclinica)
            nombres=itemview.findViewById(R.id.serv_nombres)
            origen=itemview.findViewById(R.id.serv_origin)
            destino=itemview.findViewById(R.id.serv_destino)
            recomendaciones=itemview.findViewById(R.id.serv_recomendacion)
            //status=itemview.findViewById(R.id.ser)
           // fotoServicio=itemview.findViewById(R.id.serv_foto)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        var itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.card_servicio_jefe,parent,false)
        return MiHolder(itemView)
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        var servicios=listaServicios[position]
        holder.documento.text=servicios.documento
        holder.hClinica.text=servicios.historiaClinica
        holder.nombres.text=servicios.nombrePaciente
        holder.origen.text=servicios.origenPaciente
        holder.destino.text=servicios.destinoPaciente
        holder.recomendaciones.text=servicios.recomendacines
       // holder.status.text=servicios.documento
      //  holder.fotoServicio.text=servicios.fotoOrdenServicio
    }

    override fun getItemCount(): Int {
        return listaServicios.size
    }
}