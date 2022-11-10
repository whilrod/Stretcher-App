package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.prueba1.databinding.FragmentCamillerosBinding
import com.example.prueba1.databinding.FragmentServiciosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.zip.Inflater


class ServiciosFragment : Fragment(R.layout.fragment_servicios) {

    private var _binding:  FragmentServiciosBinding?=null
    val binding get() = _binding!!
    private var fab:FloatingActionButton?= null
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
        fab=binding.agregar
        fab!!.setOnClickListener({
            startActivity(Intent(context,CreaServicio1::class.java))
        })
    }
}