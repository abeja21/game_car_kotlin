package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import pl.droidsonroids.gif.GifImageView

class ver_coches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_coches)


        val ArrayCoches= mutableListOf<Cars>();
        var fondo_coche=findViewById<ImageView>(R.id.fondo_coches)
        var gifcoche=findViewById<GifImageView>(R.id.coches)
        var aceleracion=findViewById<ProgressBar>(R.id.acelerar)
        var velocidadMaxima=findViewById<ProgressBar>(R.id.velocidad_max)
        var desaceleracion=findViewById<ProgressBar>(R.id.desacelerar)
        var gasolina=findViewById<ProgressBar>(R.id.gasolina)
        var sw_name=findViewById<TextView>(R.id.nombre_Coche)
        var sw_acc=findViewById<TextView>(R.id.valor_acc)
        var sw_vmax=findViewById<TextView>(R.id.Valor_vel)
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

        var posicion :Int=0
        val coche1=Cars("octane",70,6,3,90,R.drawable.car1,R.drawable.fondo_coche1)
        val coche2=Cars("octane V2",80,5,6,75,R.drawable.car2,R.drawable.fondo_coche1)
        val coche3=Cars("lorean",100,8,6,60,R.drawable.car3,R.drawable.fondo_coche3)
        val coche4=Cars("bearch",85,10,5,75,R.drawable.car4,R.drawable.fondo_car4)
        val coche5=Cars("Rayo Mcqueen",95,12,8,50,R.drawable.car5,R.drawable.fondo_coche5)
        ArrayCoches.add(coche1)
        ArrayCoches.add(coche2)
        ArrayCoches.add(coche3)
        ArrayCoches.add(coche4)
        ArrayCoches.add(coche5)


        aceleracion.max=30
        velocidadMaxima.max=100
        desaceleracion.max=30
        gasolina.max=100
    mostrarcoche(ArrayCoches[posicion])



    next_car.setOnClickListener {
        posicion++;
        if (posicion<ArrayCoches.size){
            mostrarcoche(ArrayCoches[posicion])
        }else{
            posicion=0;
            mostrarcoche(ArrayCoches[posicion])
        }
    }
        previous_car.setOnClickListener {
            posicion--;
        if(posicion<0){
            posicion=ArrayCoches.size-1
            mostrarcoche(ArrayCoches[posicion])
        }else{
            mostrarcoche(ArrayCoches[posicion])
        }
        }
    }
}




