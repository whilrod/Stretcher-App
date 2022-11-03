package com.example.prueba1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.prueba1.databinding.ActivityRecordarBinding
import com.example.prueba1.databinding.ActivityRegistroBinding

class RecordarActivity : Activity() {
    lateinit var binding: ActivityRecordarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recupera.setOnClickListener { valida() }
    }
    fun valida(){
        val correo:String=binding.txtEmail2.text.toString()
        val telefono:String=binding.telefono2.text.toString()
        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE)
        var email_db=pref.getString("correo","")
        var telefono_db=pref.getString("telefono","")

        var emailo:String =binding.txtEmail2.text.toString()
        if (correo.isEmpty()){
            binding.txtEmail2.background=ResourcesCompat.getDrawable(resources,R.drawable.txt_danger,null)
            binding.txtEmail2.setHint("Ingrese su correo!!!")
        }else if(telefono.isEmpty()){
            binding.telefono2.background =ResourcesCompat.getDrawable(resources, R.drawable.txt_danger, null)
            binding.telefono2.setHint("Ingrese su telefono!!!")
        }else if(correo==email_db){
            if(telefono==telefono_db){
                //Toast.makeText(this,"Bienvenido nuevamente!!!", Toast.LENGTH_LONG).show()
                val intent1 = Intent(this,NauevaPassActivity::class.java)
                intent1.putExtra("correo",correo)
                intent1.putExtra("correo",correo)
                startActivity(intent1)

            }else{
                Toast.makeText(this,"Telefono incorrecta", Toast.LENGTH_LONG).show()

            }
        }else{
            Toast.makeText(this,"Usuario no Registrado!!", Toast.LENGTH_LONG).show()
        }
    }
}