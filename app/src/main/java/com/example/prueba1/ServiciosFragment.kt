package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba1.databinding.FragmentCamillerosBinding
import com.example.prueba1.databinding.FragmentServiciosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.Inflater


class ServiciosFragment : Fragment(R.layout.fragment_servicios) , RecyclerServicio.clickServicio{

    private var _binding:  FragmentServiciosBinding?=null
    val binding get() = _binding!!
    private var fab:FloatingActionButton?= null
    lateinit var firestroreBd:FirebaseFirestore
    lateinit var intent: Intent

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

        firestroreBd=FirebaseFirestore.getInstance()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!= null){
            val documento= requireArguments().getString("documento")
            Toast.makeText(context,"$documento",Toast.LENGTH_SHORT).show()
        }
        /*lista.add(Servicios("1020346783", "HC-023","Jose Mendez", "Hab. 201","TAC 2","No"))
        binding.listaServicios.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter=RecyclerServicio(lista)
        }*/
        cargalista()
        fab=binding.agregar
        fab!!.setOnClickListener({
            startActivity(Intent(context,CreaServicio1::class.java))
        })
    }

    fun cargalista(){
        val tiempo= Calendar.getInstance().time
        val formatter= SimpleDateFormat("yyyy-MM-dd")
        val formatter2= SimpleDateFormat("HH:mm:ss")
        val fecha = formatter.format(tiempo)
        var hora = formatter2.format(tiempo)

        intent=Intent(context,DetalleServicioActivity::class.java)
        firestroreBd.collection("servicios").get().addOnSuccessListener {

            result->
            for(res in result){
                var serv= Servicios(
                    res.getString("documento") as String,
                    res.getString("hclinica") as String,
                    res.getString("nombre") as String,
                    res.getString("origen") as String,
                    res.getString("destino") as String,
                    res.getString("rutaimagen") as String,
                )
                lista.add(serv)
                binding.listaServicios.apply {
                    layoutManager= LinearLayoutManager(activity)
                    adapter=RecyclerServicio(lista,this@ServiciosFragment)
                }
            }
        }
        /*lista.add(Servicios("1020346783", "HC-023","Jose Mendez", "Hab. 201","TAC 2",  R.drawable.ic_baseline_article_24.toString()))
        binding.listaServicios.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter=RecyclerServicio(lista)
        }*/

    }

    override fun onItemClick(service: Servicios) {
        intent.putExtra("documento",service.documento)
        intent.putExtra("hclinica",service.historiaClinica)
        intent.putExtra("nombre",service.nombrePaciente)
        intent.putExtra("imagenOrden",service.imagenOrden)
        startActivity(intent)
        //Toast.makeText(context,"${service.nombrePaciente}",Toast.LENGTH_SHORT).show()
    }
}