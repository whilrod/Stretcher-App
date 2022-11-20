package com.example.prueba1


import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.prueba1.databinding.ActivityCreaServicio1Binding
import java.io.File
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class CreaServicio1 : AppCompatActivity() {
    lateinit var binding: ActivityCreaServicio1Binding
    var ruta =""
    var docu=""
    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreaServicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.btnGuardar.setOnClickListener { guardar() }
        binding.btnCamara.setOnClickListener { tomaFoto() }
        var documento :String = binding.servDocumento.text.toString()
        docu=documento
    }

    //var dir= ""
    val tiempo=Calendar.getInstance().time
    val formatter=SimpleDateFormat("yyyy-MM-dd")
    val formatter2=SimpleDateFormat("HH:mm:ss")
    val fecha = formatter.format(tiempo)
    var hora = formatter2.format(tiempo)
    //val nada=""
    lateinit var file: File
    //@RequiresApi(Build.VERSION_CODES.O)
    private fun crearArchivo(){
        docu=binding.servDocumento.text.toString()
        val dir= getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        ruta=dir.toString()
        file=File.createTempFile("ord-$docu-$fecha-$hora",".jpg",dir)
    }
    private val abrirCamara=
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            if(result.resultCode== RESULT_OK){
                val data=result.data!!
                //val bitmap=data.extras?.get("data") as Bitmap
                val bitmap = BitmapFactory.decodeFile(file.toString())
                binding.ordenImagen.setImageBitmap(bitmap)
            }
    }

    //@RequiresApi(Build.VERSION_CODES.O)
    private fun tomaFoto(){
        //abrirCamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))

        val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
        crearArchivo()
        val fotoUri=
                FileProvider.getUriForFile(this,BuildConfig.APPLICATION_ID+".fileprovider",file)
            it.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri)
        }
        abrirCamara.launch(intent)
    }

    private fun guardar(){
        docu=binding.servDocumento.text.toString()
        val hClinica :String = binding.servHclinica.text.toString()
        val nombres :String = binding.servNombres.text.toString()
        val origen :String = binding.servOrigin.text.toString()
        val destino :String = binding.servDestino.text.toString()
        val retorna:Int = binding.servRetorna.id
        val recomendaciones :String = binding.servRecomendacion.text.toString()
        val fotoRuta:String= "$ruta/$file"
        //val foto :String = binding.servFoto.text.toString()

        var pref=getSharedPreferences(docu, Context.MODE_PRIVATE)
        var editar = pref.edit()
        editar.putString("documento",docu)
        editar.putString("hClinica",hClinica)
        editar.putString("nombres",nombres)
        editar.putString("origen",origen)
        editar.putString("destino", destino)
        editar.putString("recomendaciones",recomendaciones)
        editar.putString("status","creado")
        if(retorna==0){
            editar.putString("regresa","SI")
        }else{
            editar.putString("regresa","NO")
        }
        editar.putString("fotoRuta", fotoRuta)

        val bundle=Bundle()
        bundle.putString("documento",docu)
        ServiciosFragment().arguments=bundle


        editar.commit()
        Toast.makeText(this,"Servicio Creado correctamente!",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,JefeActivity::class.java))

    }
}