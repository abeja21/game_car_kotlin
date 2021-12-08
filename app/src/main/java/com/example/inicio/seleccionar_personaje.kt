package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import pl.droidsonroids.gif.GifImageView
val ArrayPersonaje= mutableListOf<player>()
var posicion_per :Int=0
class seleccionar_personaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        val previous_per=findViewById<ImageButton>(R.id.prev_per)
        val next_per=findViewById<ImageButton>(R.id.next_per)
        val gif_per=findViewById<GifImageView>(R.id.primer_puesto)
        val name_per=findViewById<TextView>(R.id.nombre_personaje)
        val cont=findViewById<Button>(R.id.continuar)

        fun mostar_per(per:player){
            gif_per.setImageResource(per.perfil)
            name_per.setText(per.Nombre)
        }


        ArrayPersonaje.add(player("roock lee",R.drawable.roock_lee))
        ArrayPersonaje.add(player("naruto",R.drawable.naruto))
        ArrayPersonaje.add(player("shikamaru",R.drawable.shikamaru))
        ArrayPersonaje.add(player("gotenks",R.drawable.gotenks))
        ArrayPersonaje.add(player("doraemon",R.drawable.doraemon))
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
            ArrayPersonaje[posicion_per].bot=false;
            val cambiando=Intent(this,seleccionar_coche::class.java)
            startActivity(cambiando)
        }
    }

}