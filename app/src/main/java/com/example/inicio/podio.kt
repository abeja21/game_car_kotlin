package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class podio : AppCompatActivity() {
    val arraygifs= mutableListOf<GifImageView>()
    val arraynombre= mutableListOf<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podio)
        var gif1=findViewById<GifImageView>(R.id.primer_puesto)
        val gif2=findViewById<GifImageView>(R.id.segundo_puesto)
        val gif3=findViewById<GifImageView>(R.id.tercer_puesto)
        val gif4=findViewById<GifImageView>(R.id.cuarto_puesto)
        val gif5=findViewById<GifImageView>(R.id.quinto_puesto)
        val nombre1=findViewById<TextView>(R.id.primer_jugador)
        val nombre2=findViewById<TextView>(R.id.segundo_jugador)
        val nombre3=findViewById<TextView>(R.id.tercer_jugador)
        val nombre4=findViewById<TextView>(R.id.cuarto_jugador)
        val nombre5=findViewById<TextView>(R.id.quinto_jugador)
        val reiniciar=findViewById<Button>(R.id.reiniciar)
        arraygifs.add(gif1)
        arraygifs.add(gif2)
        arraygifs.add(gif3)
        arraygifs.add(gif4)
        arraygifs.add(gif5)
        arraynombre.add(nombre1)
        arraynombre.add(nombre2)
        arraynombre.add(nombre3)
        arraynombre.add(nombre4)
        arraynombre.add(nombre5)
    for (i in 0 until campeones.size){
        when(campeones[i].Nombre){
            "roock lee"->   {arraygifs[i].setImageResource(campeones[i].perfil)
                            arraynombre[i].setText(campeones[i].Nombre)}
            "naruto"  ->  {arraygifs[i].setImageResource(campeones[i].perfil)
                            arraynombre[i].setText(campeones[i].Nombre)}
            "shikamaru"->{arraygifs[i].setImageResource(campeones[i].perfil)
                arraynombre[i].setText(campeones[i].Nombre)}
            "gotenks"->{
                arraygifs[i].setImageResource(campeones[i].perfil)
                arraynombre[i].setText(campeones[i].Nombre)
            }
            "doraemon"->{
                arraygifs[i].setImageResource(campeones[i].perfil)
                arraynombre[i].setText(campeones[i].Nombre)
            }
        }
    }
    reiniciar.setOnClickListener {
        campeones.clear()
        ArrayPersonaje.clear()
        ArrayCoches.clear()
        ArrayCircuito.clear()
        Jugadores_coches.clear()
        medallas.clear()
        val cambiando= Intent(this,menu::class.java)
        startActivity(cambiando)
    }
    }
}