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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecordarActivity : Activity() {
    lateinit var binding: ActivityRecordarBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth

        binding.recupera.setOnClickListener { enviaCorreo(binding.txtEmail2.text.toString()) }
    }
    fun enviaCorreo(correo: String){

//        var taste= binding.txtEmail2.text.toString()
        Toast.makeText(this,"Correo ${correo}", Toast.LENGTH_LONG).show()

        firebaseAuth.sendPasswordResetEmail(correo).addOnCompleteListener(){
            task->
            if (task.isSuccessful){
                Toast.makeText(this,"Correo de recuperación enviado", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,MainActivity::class.java))
            }else{
                Toast.makeText(this,"Correo no registrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}