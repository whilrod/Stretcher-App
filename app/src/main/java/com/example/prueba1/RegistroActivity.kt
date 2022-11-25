package com.example.prueba1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.prueba1.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RegistroActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    lateinit var firestoreDb: FirebaseFirestore
    lateinit var firebaseauth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseauth=Firebase.auth
        firestoreDb= FirebaseFirestore.getInstance()
        binding.btnRegistrarse.setOnClickListener { guardarUsuario() }
       // binding.ingresar.setOnClickListener { validar() }
        //finish()
    }

    fun guardarUsuario(){
        var id: String
        val nombres :String = binding.nombres.text.toString()
        val apellidos : String = binding.apellidos.text.toString()
        val correo : String = binding.txtEmail.text.toString()
        val telefono : String= binding.telefono.text.toString()
        val direccion : String=binding.direccion.text.toString()
        val password : String = binding.pass1.text.toString()
        if (nombres.isEmpty()||apellidos.isEmpty()||correo.isEmpty()||telefono.isEmpty()||
                telefono.isEmpty()||direccion.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"Por favor llene los campos completamente",Toast.LENGTH_SHORT).show()
        }else {
            firebaseauth.createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        id = firebaseauth.currentUser?.uid.toString()
                        val data= hashMapOf<String,String>(
                            "nombres" to nombres,
                            "apellidos" to apellidos,
                            "correo" to correo,
                            "telefono" to telefono,
                            "direccion" to direccion,
                            "password" to password
                        )
                        firestoreDb.collection("usuarios").document(id).set(data).addOnSuccessListener {
                            task ->
                            Toast.makeText(
                                this,
                                "Usuario registrado exitosamente!!!",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(Intent(this, MainActivity::class.java))
                        }.addOnFailureListener{
                            error->
                            Toast.makeText(
                                this,
                                "Error al guardar. Intente nuevamente.",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    } else {
                        Toast.makeText(this, "Error en reistro!!!", Toast.LENGTH_LONG).show()

                    }
                }
        }
        var usuario= Usuario_Entidad(correo,nombres,apellidos,telefono,direccion,password)
/*
        val room2= Room.databaseBuilder(this,bdUsuarios::class.java,"bdCamillerosUsuarios").build()

        lifecycleScope.launch {
            room2.daoUsuario().agregarUsuario(usuario)
            var lista = room2.daoUsuario().obtenerUsuarios()
            for (usu in lista) {
                println("---->>>>>>>${usu.correo}--${usu.nombre}--${usu.apellidos}--${usu.password}--${usu.direccion}--${usu.telefonoUser}")
            }
            var usuarioEncontrado: Usuario_Entidad =
                room2.daoUsuario().buscarUsuario("sara@gmail.com")
            println("Usuario encontrado")
            println("---->>>>>>>${usuarioEncontrado.correo}--${usuarioEncontrado.nombre}--${usuarioEncontrado.apellidos}--${usuarioEncontrado.password}--${usuarioEncontrado.direccion}--${usuarioEncontrado.telefonoUser}")
        }
*/

        /*var pref=getSharedPreferences(correo, Context.MODE_PRIVATE )
        var editar=pref.edit()
        editar.putString("correo",correo)
        editar.putString("nombres",nombres)
        editar.putString("apellidos",apellidos)
        editar.putString("telefono",telefono)
        editar.putString("direccion",direccion)
        editar.putString("password",password)
        editar.putString("rol","jefe")
        editar.commit()
*/
 //       Toast.makeText(this,"Usuario registrado exitosamente!!!", Toast.LENGTH_LONG).show()
 //       startActivity(Intent(this,MainActivity::class.java))
    }

}