package com.example.prueba1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.prueba1.databinding.ActivityCamilleroBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class CamilleroActivity : AppCompatActivity() {
    lateinit var binding: ActivityCamilleroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCamilleroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.btnRegistrarse.setOnClickListener { guardarUsuario() }
        // binding.ingresar.setOnClickListener { validar() }
       // val navegacion = binding.bottomNavigationView
        val casa= CamilleroHomeFragment()
        val historico = HistoricoFragment()
        val profile=PerfilFragment()
        //Navigation
        //NavigationBarView.OnItemSelectedListener { item->
        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home ->{
                        menuInferior(casa)
                        true
                }
                R.id.histoy ->{
                    menuInferior(historico)
                    true
                }
                R.id.profile ->{
                    menuInferior(profile)
                    true
                }
                else->false
            }
        }
    }
    fun menuInferior(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmento1,fragment)
            commit()
        }
    }
}