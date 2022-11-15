package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba1.databinding.FragmentCamillerosBinding
import com.example.prueba1.databinding.FragmentServiciosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.zip.Inflater


class ServiciosFragment : Fragment(R.layout.fragment_servicios) {

    private var _binding:  FragmentServiciosBinding?=null
    val binding get() = _binding!!
    private var fab:FloatingActionButton?= null

    var lista:MutableList<Servicios> = mutableListOf()
    //var lista:MutableList<Camillero> = mutableListOf()
    lateinit var recicler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentServiciosBinding.inflate(inflater)
        var view:ConstraintLayout= binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lista.add(Servicios("1020346783", "HC-023","Jose Mendez", "Hab. 201","TAC 2","Si","No",""))
        binding.listaServicios.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter=RecyclerServicio(lista)
        }
        //cargalista()
        fab=binding.agregar
        fab!!.setOnClickListener({
            startActivity(Intent(context,CreaServicio1::class.java))
        })



    }

    fun cargalista(){
        lista.add(Servicios("1020346783", "HC-023","Jose Mendez", "Hab. 201","TAC 2","Si","No",""))
        binding.listaServicios.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter=RecyclerServicio(lista)
        }
    }
}