package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class ver_coches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_coches)
        val ArrayCoches= mutableListOf<Cars>();
        val coche1=Cars("octane",70,6,3,90,R.drawable.car1,R.drawable.fondo_coche1)
        ArrayCoches.add(coche1)
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
        aceleracion.max=30
        velocidadMaxima.max=100
        desaceleracion.max=30
        gasolina.max=100
        sw_name.setText(ArrayCoches[0].nombre.toString())
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




