package com.example.prueba1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.prueba1.databinding.FragmentCamillerosBinding

class CamillerosFragment : Fragment() {

    private var _binding:  FragmentCamillerosBinding?=null
    val binding get() = _binding!!

    var lista:MutableList<Camillero> = mutableListOf()
    lateinit var recicler:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCamillerosBinding.inflate(inflater)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lista.add(Camillero("Diana","Suarez","5559089",true,4.3,R.drawable.ic_fotouser_foreground.toString()))
        lista.add(Camillero("Juan","Perez","3002001001",false,5.0,R.drawable.ic_baseline_person_24.toString()))
        lista.add(Camillero("Jhon Marcos","Caro","3002001002",true,5.0,R.drawable.ic_baseline_person_24.toString()))
        lista.add(Camillero("Pedro José","Cifuentes","3002001003",false,1.0,R.drawable.ic_fotouser_foreground.toString()))
        lista.add(Camillero("Sarah","Rodriguez","3002001004",true,5.0,R.drawable.ic_fotouser_foreground.toString()))
        lista.add(Camillero("Juana","Jiménez","3002001005",true,5.0,R.drawable.ic_baseline_person_24.toString()))
        lista.add(Camillero("Miguel Antonio","Rojas","3002001006",true,5.0,R.drawable.ic_fotouser_foreground.toString()))
        lista.add(Camillero("Daniel Eduardo","Martínez","3002001007",true,5.0,R.drawable.ic_fotouser_foreground.toString()))
        binding.listaCamilleros.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter=RecylerCamillero(lista)
        }

    }


}