package com.example.prueba1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
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
            val pref = this.requireActivity()
                .getSharedPreferences(correo, Context.MODE_PRIVATE)
            var nombres=pref.getString("nombres","")
            var apellidos=pref.getString("apellidos","")

            var telefono=pref.getString("telefono","")
            var direccion=pref.getString("direccion","")

            binding.correoPerfil.text=correo
            binding.nombresPerfil.text=nombres
            binding.apellidosPerfil.text=apellidos
            binding.telefonoPerfil.text=telefono
            binding.direccionPerfil.text=direccion

            Toast.makeText(context,"Usuario: "+ correo,Toast.LENGTH_SHORT).show()
        }



    }



}