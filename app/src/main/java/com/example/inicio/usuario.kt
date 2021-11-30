package com.example.inicio

import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import pl.droidsonroids.gif.GifImageView

class usuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        val ArrayPersonaje= mutableListOf<personaje>();
        val previous_per=findViewById<ImageButton>(R.id.prev_per)
        val next_per=findViewById<ImageButton>(R.id.next_per)
        val gif_per=findViewById<GifImageView>(R.id.gif_pers)
        val name_per=findViewById<TextView>(R.id.nombre_personaje)
        val cont=findViewById<Button>(R.id.continuar)

        fun mostar_per(per:personaje){
            gif_per.setImageResource(per.perfil)
            name_per.setText(per.Nombre)
        }
        var posicion_per :Int=0

        ArrayPersonaje.add(personaje("roock lee",R.drawable.roock_lee))
        ArrayPersonaje.add(personaje("naruto",R.drawable.naruto))
        ArrayPersonaje.add(personaje("shikamaru",R.drawable.shikamaru))
        ArrayPersonaje.add(personaje("gotenks",R.drawable.gotenks))
        ArrayPersonaje.add(personaje("doraemon",R.drawable.doraemon))
        mostar_per(ArrayPersonaje[0])


        previous_per.setOnClickListener {
            posicion_per--;
            if(posicion_per<0){
                posicion_per=ArrayPersonaje.size-1
                mostar_per(ArrayPersonaje[posicion_per])
            }else{
                mostar_per(ArrayPersonaje[posicion_per])
            }
        }
        next_per.setOnClickListener {
            posicion_per++;
            if (posicion_per<ArrayPersonaje.size){
                mostar_per(ArrayPersonaje[posicion_per])
            }else{
                posicion_per=0;
                mostar_per(ArrayPersonaje[posicion_per])
            }
        }
        cont.setOnClickListener {
            val cambiando=Intent(this,prepartida::class.java)
            startActivity(cambiando)
        }
    }
}