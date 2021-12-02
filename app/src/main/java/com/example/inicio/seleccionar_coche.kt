package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import pl.droidsonroids.gif.GifImageView

import kotlin.random.Random

var posicion_coches :Int=0
val ArrayCoches= mutableListOf<Cars>();
var Jugadores_coches= mutableMapOf<player,Cars>()

class seleccionar_coche : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepartida)

        var continuar=findViewById<Button>(R.id.comenzar1)
        var fondo_coche=findViewById<ImageView>(R.id.fondo_coches_1)
        var gifcoche=findViewById<GifImageView>(R.id.coches1)
        var aceleracion=findViewById<ProgressBar>(R.id.acelerar)
        var velocidadMaxima=findViewById<ProgressBar>(R.id.velocidad_max)
        var desaceleracion=findViewById<ProgressBar>(R.id.desacelerar)
        var gasolina=findViewById<ProgressBar>(R.id.gasolina)
        var sw_name=findViewById<TextView>(R.id.nombre_Coche)
        var sw_acc=findViewById<TextView>(R.id.valor_acc)
        var sw_vmax=findViewById<TextView>(R.id.Valor_vel1)
        var sw_desc=findViewById<TextView>(R.id.valor_desc)
        var sw_gas=findViewById<TextView>(R.id.valor_gas)
        var next_car=findViewById<ImageButton>(R.id.Next_Car)
        var previous_car=findViewById<ImageButton>(R.id.Previous_Car)
        fun mostrarcoche(coche:Cars){
            fondo_coche.setImageResource(coche.fondo)
            sw_name.setText(coche.nombre)
            sw_acc.setText(coche.aceleracion.toString())
            sw_desc.setText(coche.desaceleracion.toString())
            sw_gas.setText(coche.gasolina.toString())
            sw_vmax.setText(coche.velocidadMaxima.toString())
            gifcoche.setImageResource(coche.design)
            velocidadMaxima.setProgress(coche.velocidadMaxima)
            aceleracion.setProgress(coche.aceleracion)
            desaceleracion.setProgress(coche.desaceleracion)
            gasolina.setProgress(coche.gasolina)
        }



        ArrayCoches.add(Cars("octane",70,6,3,90,R.drawable.car1,R.drawable.fondo_coche1))
        ArrayCoches.add(Cars("octane V2",80,5,6,75,R.drawable.car2,R.drawable.fondo_coche1))
        ArrayCoches.add(Cars("lorean",100,8,6,60,R.drawable.car3,R.drawable.fondo_coche3))
        ArrayCoches.add(Cars("bearch",85,10,5,75,R.drawable.car4,R.drawable.fondo_car4))
        ArrayCoches.add(Cars("Rayo Mcqueen",95,12,8,50,R.drawable.car5,R.drawable.fondo_coche5))


        aceleracion.max=30
        velocidadMaxima.max=100
        desaceleracion.max=30
        gasolina.max=100
        mostrarcoche(ArrayCoches[posicion_coches])



        next_car.setOnClickListener {
            posicion_coches++;
            if (posicion_coches<ArrayCoches.size){
                mostrarcoche(ArrayCoches[posicion_coches])
            }else{
                posicion_coches=0;
                mostrarcoche(ArrayCoches[posicion_coches])
            }
        }
        previous_car.setOnClickListener {
            posicion_coches--;
            if(posicion_coches<0){
                posicion_coches=ArrayCoches.size-1
                mostrarcoche(ArrayCoches[posicion_coches])
            }else{
                mostrarcoche(ArrayCoches[posicion_coches])
            }
        }
        continuar.setOnClickListener {
            for (i in 0..ArrayPersonaje.size-1){
                if (ArrayPersonaje[i].bot==false){
                    Jugadores_coches.put(ArrayPersonaje[i], ArrayCoches[posicion_coches])
                }else{
                    Jugadores_coches.put(ArrayPersonaje[i], ArrayCoches[Random.nextInt(0,
                        ArrayCoches.size-1)])
                }
            }
            val cambiando= Intent(this,Select_Circuitos::class.java)
            startActivity(cambiando)

        }
    }
}