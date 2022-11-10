package com.example.prueba1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import com.example.prueba1.databinding.ActivityRegistroBinding

class RegistroActivity : Activity() {
    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistrarse.setOnClickListener { guardarUsuario() }
       // binding.ingresar.setOnClickListener { validar() }
    }

    fun guardarUsuario(){
        val nombres :String = binding.nombres.text.toString()
        val apellidos : String = binding.nombres.text.toString()
        val correo : String = binding.txtEmail.text.toString()
        val telefono : String= binding.telefono.text.toString()
        val direccion : String=binding.direccion.text.toString()
        val password : String = binding.pass1.text.toString()

        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE )
        var editar=pref.edit()
        editar.putString("correo",correo)
        editar.putString("nombres",nombres)
        editar.putString("apellidos",apellidos)
        editar.putString("telefono",telefono)
        editar.putString("direccion",direccion)
        editar.putString("password",password)
        editar.putString("rol","camillero")
        editar.commit()

        Toast.makeText(this,"Usuario registrado exitosamente!!!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MainActivity::class.java))
    }

}