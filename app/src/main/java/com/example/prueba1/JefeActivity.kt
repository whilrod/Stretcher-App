package com.example.prueba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.prueba1.databinding.ActivityCamilleroBinding
import com.example.prueba1.databinding.ActivityJefeBinding
import com.google.android.material.navigation.NavigationBarView

class JefeActivity : AppCompatActivity() {

    lateinit var binding: ActivityJefeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJefeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val servicios=ServiciosFragment()
        val camilleros=CamillerosFragment()
        val historico=HistoricoJefeFragment()
        val perfil=PerfilFragment()

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
                else->false
            }
        }

    }

    fun menuInferior(fragment2: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment2,fragment2)
            commit()
        }
    }
}