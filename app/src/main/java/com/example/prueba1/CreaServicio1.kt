package com.example.prueba1


import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore


import androidx.activity.result.contract.ActivityResultContracts
import com.example.prueba1.databinding.ActivityCreaServicio1Binding


class CreaServicio1 : AppCompatActivity() {
    lateinit var binding: ActivityCreaServicio1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreaServicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGuardar.setOnClickListener { guardar() }
        //binding.btnCamara.setOnClickListener { tomaFoto() }
        abrirCamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }
    private val abrirCamara=
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            if(result.resultCode== RESULT_OK){
                val data=result.data!!
                val bitmap=data.extras?.get("data") as Bitmap
                binding.servFoto.setImageBitmap(bitmap)
            }
    }


    private fun guardar(){
       /* val documento :String = binding.servDocumento.text.toString()
        val hClinica :String = binding.servHclinica.text.toString()
        val nombres :String = binding.servNombres.text.toString()
        val origen :String = binding.servOrigin.text.toString()
        val destino :String = binding.servDestino.text.toString()
        val retorna:Int = binding.servRetorna.id
        val recomendaciones :String = binding.servRecomendacion.text.toString()
        //val foto :String = binding.servFoto.text.toString()

        var pref=getSharedPreferences(documento,Context.MODE_PRIVATE)
        var editar = pref.edit()
        editar.putString("documento",documento)
        editar.putString("hClinica",hClinica)
        editar.putString("nombres",nombres)
        editar.putString("origen",origen)
        editar.putString("destino", destino)
        editar.putString("recomendaciones",recomendaciones)
        editar.putString("status","creado")
        if(retorna==0){
            editar.putString("genero","SI")
        }else{
            editar.putString("genero","NO")
        }

        editar.commit()
        Toast.makeText(this,"Servicio Creado correctamente!",Toast.LENGTH_LONG).show()
*/
    }
}