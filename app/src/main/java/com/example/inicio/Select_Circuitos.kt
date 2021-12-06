package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
val ArrayCircuito= mutableListOf<circuit>()
lateinit var circuito_seleccionado:circuit


class Select_Circuitos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_circuitos)

        val imagen_circuito=findViewById<ImageView>(R.id.imagen_circuito)
        val nombre_circuito=findViewById<TextView>(R.id.nombre_circuito)
        val siguiente_circuito=findViewById<ImageButton>(R.id.siguiente_circuito)
        val anterior_circuito=findViewById<ImageButton>(R.id.anterior_circuito)
        val estrellas=findViewById<RatingBar>(R.id.dificultad)
        val comenzar=findViewById<Button>(R.id.Comenzar)
        var posicion=0;

         fun mostarCircuito(circuito: circuit){
            imagen_circuito.setImageResource(circuito.imagen)
            nombre_circuito.setText(circuito.nombre)
            estrellas.rating= circuito.dificultad.toFloat()

        }

        ArrayCircuito.add(circuit("circuito champiñon",R.drawable.circuito1,1,arrayOf('r','r','c','r','c','r','r','r','c','c','r')))
        ArrayCircuito.add(circuit("circuito platano",R.drawable.circuito2,3,arrayOf('r','r','r','r','c','c','r','c','c','r','c','r','r','c','c','r','r','r')))
        ArrayCircuito.add(circuit("circuito rayo",R.drawable.circuito3,5,arrayOf('r','c','c','c','r','r','c','c','c','c','r','r','r','r','r','c','c','c','c','c','c','r','r')))
        mostarCircuito(ArrayCircuito[posicion])

        siguiente_circuito.setOnClickListener {
            posicion++;
            if (posicion<ArrayCircuito.size){
                mostarCircuito(ArrayCircuito[posicion])
            }else{
                posicion=0;
                mostarCircuito(ArrayCircuito[posicion])
            }
        }

        anterior_circuito.setOnClickListener {
            posicion--;
            if(posicion<0){
                posicion=ArrayCircuito.size-1
                mostarCircuito(ArrayCircuito[posicion])
            }else{
                mostarCircuito(ArrayCircuito[posicion])
            }
        }
        comenzar.setOnClickListener {
            circuito_seleccionado= ArrayCircuito[posicion]
            val cambiando= Intent(this,juego::class.java)
            startActivity(cambiando)
        }
    }
}