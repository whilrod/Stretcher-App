package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.prueba1.databinding.ActivityCamilleroBinding
import com.example.prueba1.databinding.ActivityJefeBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JefeActivity : AppCompatActivity() {
    lateinit var binding: ActivityJefeBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJefeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correo= intent.getStringExtra("correo").toString()
        Toast.makeText(this,"Bienvenido: $correo" , Toast.LENGTH_SHORT).show()
        val servicios=ServiciosFragment()
        val camilleros=CamillerosFragment()
        val historico=HistoricoJefeFragment()
        val perfil=PerfilFragment()
        firebaseAuth=Firebase.auth


        //envia datos a fragment//

        val bundle=Bundle()
        bundle.putString("correo",correo)
        perfil.arguments=bundle

        //NavigationBarView.OnItemSelectedListener { item->
            binding.bottomNavigationView2.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.servicios ->{
                    menuInferior(servicios)
                    true
                }
                R.id.camilleros ->{
                    menuInferior(camilleros)
                    true
                }
                R.id.historico ->{
                    menuInferior(historico)
                    true
                }

                R.id.perfil ->{
                    menuInferior(perfil)
                    true
                }
                R.id.cierrraSesion ->{
                    firebaseAuth.signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else->false
            }
        }

    }

    fun menuInferior(fragment2: Fragment){
/*        val fmanager=supportFragmentManager
        val fmanagertrans=fmanager.beginTransaction()
        //val fragment2

            val databundle = Bundle()
            databundle.putString("correo", dato)
            fragment2.arguments = databundle
            fmanagertrans.add(R.id.fragment2, fragment2).commit()
*/
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment2,fragment2)
            commit()
        }
    }
}