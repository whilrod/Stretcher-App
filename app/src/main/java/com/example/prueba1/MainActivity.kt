package com.example.prueba1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.prueba1.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var correoDb: String= ""
        var passDb: String= ""
        val correo:String=binding.email.text.toString()
        val room= Room.databaseBuilder(this,bdUsuarios::class.java,"bdCamillerosUsuarios").build()
        firebaseAuth= Firebase.auth

/*        binding.ingresar.setOnClickListener {
            lifecycleScope.launch(){
                var usuRes = room.daoUsuario().buscarUsuario(correo )
                correoDb=usuRes.correo
                passDb=usuRes.password
                //println("___>>>>>>${usuRes.correo}--${usuRes.nombre}--${usuRes.password}--${usuRes.direccion}")
                validaRoom2(correoDb!!,passDb!!)
            }
             }*/
        binding.email.setOnClickListener{limpia()}
        /*binding.password.setOnClickListener { lifecycleScope.launch(){
            var usuRes = room.daoUsuario().buscarUsuario(correo )
            correoDb=binding.email.text.toString()
            passDb=binding.password.text.toString()
            //println("___>>>>>>${usuRes.correo}--${usuRes.nombre}--${usuRes.password}--${usuRes.direccion}")
            validar2(correoDb!!,passDb!!)
            }
        }*/
        binding.ingresar.setOnClickListener { validaFirebase() }
        binding.registrar.setOnClickListener { registra() }
        binding.recordar.setOnClickListener { recuperar() }
       // binding.registrar
    }
    fun registra(){
        startActivity(Intent(this,RegistroActivity::class.java))
    }

    fun validaFirebase(){
        val correo:String=binding.email.text.toString()
        val password:String=binding.password.text.toString()
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
        }else run {
            firebaseAuth.signInWithEmailAndPassword(correo, password).addOnCompleteListener(this){
                task ->
                if(task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    if (user != null) {
                        //Toast.makeText(this,"Bienvenido nuevamente ${user.email}!!!",Toast.LENGTH_LONG).show()
                        val intent1 = Intent(this,JefeActivity::class.java)
                        intent1.putExtra("correo",correo)
                        startActivity(intent1)
                    }else{
                        Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_LONG).show()
                }
            }
        }
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
    fun validar2(correoDb: String,passDb: String){
        validaRoom2(binding.email.text.toString(),binding.password.text.toString())
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


    //var usuRes:String=""
    fun validaRoom2(correoDb: String,passDb: String){
        val correo:String=binding.email.text.toString()
        val password:String=binding.password.text.toString()
        //var correoDb: String= ""
        //var passDb: String= ""
        /*val room= Room.databaseBuilder(this,bdUsuarios::class.java,"bdCamillerosUsuarios").build()
        lifecycleScope.launch(){
            var usuRes = room.daoUsuario().buscarUsuario(correo )
            correoDb=usuRes.correo
            passDb=usuRes.password
        }*/

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
        }else if(correo==correoDb){
            if(password==passDb){
                //Toast.makeText(this,"Bienvenido nuevamente!!!",Toast.LENGTH_LONG).show()
                binding.email.setText("")
                binding.password.setText("")

                val intent1 = Intent(this,JefeActivity::class.java)
                intent1.putExtra("correo",correo)
                startActivity(intent1)
                }else{
                Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Usuario no Registrado!!",Toast.LENGTH_LONG).show()
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
                //Toast.makeText(this,"Bienvenido nuevamente!!!",Toast.LENGTH_LONG).show()
                binding.email.setText("")
                binding.password.setText("")
                when(rol_db){
                    "camillero"->{
                        val intent1 = Intent(this,CamilleroActivity::class.java)
                        intent1.putExtra("correo",correo)
                        startActivity(intent1)
                       // startActivity(Intent(this,CamilleroActivity::class.java))
                    }
                    "jefe"->{
                        val intent1 = Intent(this,JefeActivity::class.java)
                        intent1.putExtra("correo",correo)
                        startActivity(intent1)
                        //startActivity(Intent(this,JefeActivity::class.java))
                    }
                    "administrador"->{
                        val intent1 = Intent(this,JefeActivity::class.java)
                        intent1.putExtra("correo",correo)
                        startActivity(intent1)
                    }
                    else->{
                        val intent1 = Intent(this,CamilleroActivity::class.java)
                        intent1.putExtra("correo",correo)
                        startActivity(intent1)
                        //startActivity(Intent(this,JefeActivity::class.java))
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