package com.example.prueba1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba1.databinding.ActivityNauevaPassBinding
import com.example.prueba1.databinding.ActivityRecordarBinding


class NauevaPassActivity : Activity() {
    lateinit var binding: ActivityNauevaPassBinding
    public var dato:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNauevaPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras
        dato= bundle?.getString("correo").toString()
        binding.recupera2.setOnClickListener { guarda() }
        //Toast.makeText(this,"Bienvenido ${dato}!!!", Toast.LENGTH_LONG).show()
   //     binding.recupera.setOnClickListener { guarda() }
    }

    fun guarda(){
        val pass = binding.pass.text.toString()
        val pass2= binding.pass2.text.toString()
        /*val correo:String=binding.txtEmail2.text.toString()
        val telefono:String=binding.telefono2.text.toString()
        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE)
        var email_db=pref.getString("correo","")
        var telefono_db=pref.getString("telefono","")
        */
        if (pass.isEmpty()){
            binding.pass.setHintTextColor(Color.RED)
            //binding.pass.setTextColor(Color.RED)
        }else if (pass2.isEmpty()){
            binding.pass2.setHintTextColor(Color.RED)
            //binding.pass2.setTextColor(Color.RED)
        } else if (pass!=pass2){
            Toast.makeText(this,"Contraseñas no coinciden. Por favor intente de nuevo",Toast.LENGTH_LONG).show()
        }else{ Toast.makeText(this,"Cambio Exitoso!!!",Toast.LENGTH_LONG).show()
        }


        var pref=getSharedPreferences(dato, Context.MODE_PRIVATE )
        var editar=pref.edit()
        editar.putString("password",pass)
        editar.commit()
        startActivity(Intent(this,MainActivity::class.java))
       /* editar.putString("correo",correo)
        editar.putString("nombres",nombres)
        editar.putString("apellidos",apellidos)
        editar.putString("telefono",telefono)
        editar.putString("direccion",direccion)
        editar.putString("password",password)
        editar.commit()*/
    }
}
