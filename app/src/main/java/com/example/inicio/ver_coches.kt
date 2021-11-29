package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
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
        val coche1=Cars("octane",70,6,3,90,R.drawable.car1,R.drawable.fondo_coche1)
        val coche2=Cars("octane V2",80,5,6,75,R.drawable.car2,R.drawable.fondo_coche1)
        val coche3=Cars("lorean",100,8,6,60,R.drawable.car2,R.drawable.fondo_coche3)
        val coche4=Cars("bearch",85,10,5,75,R.drawable.car4,R.drawable.fondo_car4)
        val coche5=Cars("Rayo Mcqueen",95,12,8,50,R.drawable.car5,R.drawable.fondo_coche1)
        ArrayCoches.add(coche1)
        ArrayCoches.add(coche2)
        ArrayCoches.add(coche3)
        ArrayCoches.add(coche4)
        ArrayCoches.add(coche5)
        aceleracion.max=30
        velocidadMaxima.max=100
        desaceleracion.max=30
        gasolina.max=100
        fondo_coche.setImageResource(ArrayCoches[0].fondo)
        sw_name.setText(ArrayCoches[0].nombre)
        sw_acc.setText(ArrayCoches[0].aceleracion.toString())
        sw_desc.setText(ArrayCoches[0].desaceleracion.toString())
        sw_gas.setText(ArrayCoches[0].gasolina.toString())
        sw_vmax.setText(ArrayCoches[0].velocidadMaxima.toString())
        gifcoche.setImageResource(ArrayCoches[0].design)
        velocidadMaxima.setProgress(ArrayCoches[0].velocidadMaxima)
        aceleracion.setProgress(ArrayCoches[0].aceleracion)
        desaceleracion.setProgress(ArrayCoches[0].desaceleracion)
        gasolina.setProgress(ArrayCoches[0].gasolina)


    }
}




