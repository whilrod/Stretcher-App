package com.example.prueba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.prueba1.databinding.ActivityDetalleServicioBinding

class DetalleServicioActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleServicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetalleServicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var documento= intent.getStringExtra("documento")
        var hclinica= intent.getStringExtra("hclinica")
        var nombre= intent.getStringExtra("nombre")
        var imagenOrden= intent.getStringExtra("imagenOrden")
        binding.documentoServicio.text=documento
        binding.hclinicaServicio.text=hclinica
        binding.nombresServicio.text=nombre
        Glide.with(this)
            .load(imagenOrden)
            .into(binding.imagenServicio)
    }
}