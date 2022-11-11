package com.example.prueba1

import android.content.Intent
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
import com.example.prueba1.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {
    private var _binding:  FragmentPerfilBinding?=null
    val binding get() = _binding!!

    //var lista:MutableList<Camillero> = mutableListOf()
    //lateinit var recicler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*var view: FrameLayout = binding.root
        val databundle= arguments
        val dato= databundle!!.getString("correo")
        Toast.makeText(context,"Usuario: "+ dato,Toast.LENGTH_SHORT).show()
*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var intent= Intent(context,PerfilFragment::class.java)

        if(arguments!=null){
            val correo= requireArguments().getString("correo")
            binding.correo.text=correo
            Toast.makeText(context,"Usuario: "+ correo,Toast.LENGTH_SHORT).show()
        }


    }


}