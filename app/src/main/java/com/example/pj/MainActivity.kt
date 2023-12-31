package com.example.pj

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var spinnerRaza: Spinner
    private lateinit var spinnerClase: Spinner
    private lateinit var spinnerEstadoVital: Spinner

    // Define a map
    private val imagenes = mutableMapOf<String, Int>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        spinnerRaza = findViewById(R.id.raza)
        spinnerClase = findViewById(R.id.clase)
        spinnerEstadoVital = findViewById(R.id.estadoVital)

        val editText = findViewById<EditText>(R.id.nombre)
        val btn = findViewById<Button>(R.id.btn)
        val valoresRaza= arrayOf("Humano","Enano", "Elfo", "Maldito")
        val valoresClase= arrayOf("Humano","Enano", "Elfo", "Maldito")
        val valoresEstadoVital= arrayOf("Humano","Enano", "Elfo", "Maldito")

        //Da error implementar los arrays

        val raza = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("Humano","Enano", "Elfo", "Maldito"))
        val clase = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("Mago", "Brujo", "Guerrero"))
        val estadoVital = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("Joven", "Adulto", "Anciano"))

        spinnerRaza.adapter = raza
        spinnerClase.adapter = clase
        spinnerEstadoVital.adapter = estadoVital

        val elecionSp = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val raza = spinnerRaza.selectedItem.toString()
                val clase = spinnerClase.selectedItem.toString()
                val estadoVital = spinnerEstadoVital.selectedItem.toString()



                imagenes["$raza-$clase-$estadoVital"]?.let { img.setImageResource(it) }

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerRaza.onItemSelectedListener = elecionSp
        spinnerClase.onItemSelectedListener = elecionSp
        spinnerEstadoVital.onItemSelectedListener = elecionSp


        imagenes["Enano-Mago-Joven"] = R.drawable.enanomagojoven
        imagenes["Enano-Brujo-Joven"] = R.drawable.enanobrujojoven
        imagenes["Enano-Guerrero-Joven"] = R.drawable.enanoguerrerojoven
        imagenes["Enano-Mago-Adulto"] = R.drawable.enanomagoadulto
        imagenes["Enano-Brujo-Adulto"] = R.drawable.enanobrujoadulto
        imagenes["Enano-Guerrero-Adulto"] = R.drawable.enanoguerreroadulto
        imagenes["Enano-Mago-Anciano"] = R.drawable.enanomagoanciano
        imagenes["Enano-Brujo-Anciano"] = R.drawable.enanobrujoanciano
        imagenes["Enano-Guerrero-Anciano"] = R.drawable.enanoguerreroanciano
        imagenes["Humano-Mago-Joven"] = R.drawable.humanomagojoven
        imagenes["Humano-Brujo-Joven"] = R.drawable.humanobrujojoven
        imagenes["Humano-Guerrero-Joven"] = R.drawable.humanoguerrerojoven
        imagenes["Humano-Mago-Adulto"] = R.drawable.humanomagoadulto
        imagenes["Humano-Brujo-Adulto"] = R.drawable.humanobrujoadulto
        imagenes["Humano-Guerrero-Adulto"] = R.drawable.humanoguerreroadulto
        imagenes["Humano-Mago-Anciano"] = R.drawable.humanomagoanciano
        imagenes["Humano-Brujo-Anciano"] = R.drawable.humanobrujoanciano
        imagenes["Humano-Guerrero-Anciano"] = R.drawable.humanoguerreroanciano
        imagenes["Elfo-Mago-Joven"] = R.drawable.elfomagojoven
        imagenes["Elfo-Brujo-Joven"] = R.drawable.elfobrujojoven
        imagenes["Elfo-Guerrero-Joven"] = R.drawable.elfoguerrerojoven
        imagenes["Elfo-Mago-Adulto"] = R.drawable.elfomagoadulto
        imagenes["Elfo-Brujo-Adulto"] = R.drawable.elfobrujoadulto
        imagenes["Elfo-Guerrero-Adulto"] = R.drawable.elfoguerreroadulto
        imagenes["Elfo-Mago-Anciano"] = R.drawable.elfomagoanciano
        imagenes["Elfo-Brujo-Anciano"] = R.drawable.elfobrujoanciano
        imagenes["Elfo-Guerrero-Anciano"] = R.drawable.elfoguerreroanciano
        imagenes["Maldito-Mago-Joven"] = R.drawable.malditomagojoven
        imagenes["Maldito-Brujo-Joven"] = R.drawable.malditobrujojoven
        imagenes["Maldito-Guerrero-Joven"] = R.drawable.malditoguerrerojoven
        imagenes["Maldito-Mago-Adulto"] = R.drawable.malditomagoadulto
        imagenes["Maldito-Brujo-Adulto"] = R.drawable.malditobrujoadulto
        imagenes["Maldito-Guerrero-Adulto"] = R.drawable.malditoguerreroadulto
        imagenes["Maldito-Mago-Anciano"] = R.drawable.malditomagoanciano
        imagenes["Maldito-Brujo-Anciano"] = R.drawable.malditobrujoanciano
        imagenes["Maldito-Guerrero-Anciano"] = R.drawable.malditoguerreroanciano



        btn.setOnClickListener {

            val nombre = editText.text.toString()
            val raza = spinnerRaza.selectedItem.toString()
            val estadoVital = spinnerEstadoVital.selectedItem.toString()
            val clase = spinnerClase.selectedItem.toString()
            val pesoMochila = 10


            val p = Personaje(raza, nombre, clase, estadoVital, pesoMochila)

            val intent = Intent(this, PersonajeCreado::class.java)
            intent.putExtra("personaje", p)
            val imagen = imagenes["$raza-$clase-$estadoVital"] ?: R.drawable.malditobrujoanciano
            intent.putExtra("img",imagen)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
