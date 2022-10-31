package com.example.prueba1

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba1.databinding.ActivityNauevaPassBinding
import com.example.prueba1.databinding.ActivityRecordarBinding

class NauevaPassActivity : Activity() {
    lateinit var binding: ActivityNauevaPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNauevaPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
   //     binding.recupera.setOnClickListener { guarda() }
    }

    fun guarda(){
        /*val correo:String=binding.txtEmail2.text.toString()
        val telefono:String=binding.telefono2.text.toString()
        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE)
        var email_db=pref.getString("correo","")
        var telefono_db=pref.getString("telefono","")

        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE )
        var editar=pref.edit()
        editar.putString("correo",correo)
        editar.putString("nombres",nombres)
        editar.putString("apellidos",apellidos)
        editar.putString("telefono",telefono)
        editar.putString("direccion",direccion)
        editar.putString("password",password)
        editar.commit()*/
    }
}
