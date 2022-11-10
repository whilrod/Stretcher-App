package com.example.prueba1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.prueba1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ingresar.setOnClickListener { validar() }
        binding.email.setOnClickListener{limpia()}
        binding.password.setOnClickListener { validar2() }
        binding.registrar.setOnClickListener { registra() }
        binding.recordar.setOnClickListener { recuperar() }
       // binding.registrar
    }
    fun registra(){
        startActivity(Intent(this,RegistroActivity::class.java))
    }

    fun limpia() {
       // binding.email.setBackgroundColor(Color.LTGRAY)
        binding.email.setHint("Email")
        binding.email.background=ResourcesCompat.getDrawable(resources,R.drawable.txt_username,null)

        if(binding.email.text.isEmpty()){
            binding.email.requestFocus()
        }else{
            binding.password.requestFocus()
        }
    }
    fun validar2(){
        validar()
        limpia2()
    }

    fun limpia2() {
        // binding.email.setBackgroundColor(Color.LTGRAY)
        binding.password.setHint("Password")
        binding.password.background=ResourcesCompat.getDrawable(resources,R.drawable.txt_username,null)

        if(binding.password.text.isEmpty()){
            binding.password.requestFocus()
        }else{
            binding.email.requestFocus()
        }
    }

    fun validar(){
        val correo:String=binding.email.text.toString()
        val password:String=binding.password.text.toString()
        var pref=getSharedPreferences(correo,Context.MODE_PRIVATE)
        var email_db=pref.getString("correo","")
        var pass_db=pref.getString("password","")
        var rol_db=pref.getString("rol","")
        if (correo.isEmpty()){
            //binding.email.setTextColor(0x00F8EE7B)
            binding.email.background=ResourcesCompat.getDrawable(resources,R.drawable.txt_danger,null)
            binding.email.setHint("Ingrese su correo!!!")
            //binding.password.setBackgroundColor(Color.RED)
        } else if (password.isEmpty()) {
            //binding.email.setTextColor(0x00F8EE7B)
            binding.password.background =ResourcesCompat.getDrawable(resources, R.drawable.txt_danger, null)
            binding.password.setHint("Ingrese su password!!!")
            //binding.password.setBackgroundColor(Color.RED)
        }else if(correo==email_db){
            if(password==pass_db){
                Toast.makeText(this,"Bienvenido nuevamente!!!",Toast.LENGTH_LONG).show()
                binding.email.setText("")
                binding.password.setText("")
                when(rol_db){
                    "camillero"->{
                        startActivity(Intent(this,CamilleroActivity::class.java))
                    }
                    "jefe"->{
                        startActivity(Intent(this,JefeActivity::class.java))
                    }
                    "administrador"->{

                    }
                    else->{
                        startActivity(Intent(this,JefeActivity::class.java))
                    }
                }



            }else{
                Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Usuario no Registrado!!",Toast.LENGTH_LONG).show()
        }
    }

    fun recuperar(){
        startActivity(Intent(this,RecordarActivity::class.java))
    }

}