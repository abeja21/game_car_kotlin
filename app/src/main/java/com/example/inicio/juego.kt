package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView
import java.lang.Integer.parseInt
import kotlin.concurrent.thread

var campeones= mutableListOf<String>();
var partida=Race(Jugadores_coches, circuito_seleccionado)
var indicador=0
class juego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        var carretera1=findViewById<ProgressBar>(R.id.carrera1)
        var carretera2=findViewById<ProgressBar>(R.id.carrera2)
        var carretera3=findViewById<ProgressBar>(R.id.carrera3)
        var carretera4=findViewById<ProgressBar>(R.id.carrera4)
        var carretera5=findViewById<ProgressBar>(R.id.carrera5)
        var gif1=findViewById<GifImageView>(R.id.gif_pers1)
        var gif2=findViewById<GifImageView>(R.id.gif_pers2)
        var gif3=findViewById<GifImageView>(R.id.gif_pers3)
        var gif4=findViewById<GifImageView>(R.id.gif_pers4)
        var gif5=findViewById<GifImageView>(R.id.gif_pers5)
        var nom1=findViewById<TextView>(R.id.jugador1)
        var nom2=findViewById<TextView>(R.id.jugador2)
        var nom3=findViewById<TextView>(R.id.jugador3)
        var nom4=findViewById<TextView>(R.id.jugador4)
        var nom5=findViewById<TextView>(R.id.jugador5)
        gif1.setImageResource(ArrayPersonaje[0].perfil)
        gif2.setImageResource(ArrayPersonaje[1].perfil)
        gif3.setImageResource(ArrayPersonaje[2].perfil)
        gif4.setImageResource(ArrayPersonaje[3].perfil)
        gif5.setImageResource(ArrayPersonaje[4].perfil)
        nom1.setText(ArrayPersonaje[0].Nombre)
        nom2.setText(ArrayPersonaje[1].Nombre)
        nom3.setText(ArrayPersonaje[2].Nombre)
        nom4.setText(ArrayPersonaje[3].Nombre)
        nom5.setText(ArrayPersonaje[4].Nombre)
        carretera1.max= partida.circuito.distance
        carretera2.max= partida.circuito.distance
        carretera3.max= partida.circuito.distance
        carretera4.max= partida.circuito.distance
        carretera5.max= partida.circuito.distance

        fun moverse(coche:Cars,position:Char){
            when(position){
                'c'-> coche.frenar()
                'r'->coche.acelerate()
            }
        }
        fun update(player_position:Int,distancia_recorrida:Int){
            when(player_position){
                0->carretera1.setProgress(distancia_recorrida)
                1->carretera2.setProgress(distancia_recorrida)
                2->carretera3.setProgress(distancia_recorrida)
                3->carretera4.setProgress(distancia_recorrida)
                4->carretera5.setProgress(distancia_recorrida)
            }

        }
        fun play(){
            Thread(Runnable {
                while (partida.playing){

                    if (indicador< ArrayPersonaje.size){
                        if(ArrayCoches[partida.jugadores[indicador]!!].ingame){
                            if (ArrayCoches[partida.jugadores[indicador]!!].dr< partida.circuito.distance ){
                                println("${ArrayPersonaje[indicador].Nombre}= dr->${ArrayCoches[partida.jugadores[indicador]!!].dr} vl->${ArrayCoches[partida.jugadores[indicador]!!].velin}")
                                moverse(ArrayCoches[partida.jugadores[indicador]!!], partida.circuito.track[ArrayCoches[partida.jugadores[indicador]!!].dr/100])
                                update(indicador, ArrayCoches[partida.jugadores[indicador]!!].dr)
                                Thread.sleep(100)
                            }else{
                                ArrayCoches[partida.jugadores[indicador]!!].ingame=false
                                campeones.add(ArrayPersonaje[indicador].Nombre)

                                if (campeones.size== ArrayPersonaje.size){

                                    partida.playing=false
                                }
                            }
                        }
                        indicador++
                    }else{
                        indicador=0
                    }


                }
            }).start()

            println(campeones.toString())
             }
        play()
    }

}