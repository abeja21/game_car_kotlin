package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var ver_coche=findViewById<Button>(R.id.ver_coches)
        var jugar=findViewById<Button>(R.id.jugar)



        ver_coche.setOnClickListener {
            val cambiando= Intent(this,ver_coches::class.java)
            startActivity(cambiando)
        }
    jugar.setOnClickListener {
        val cambiando=Intent(this,prepartida::class.java)
        startActivity(cambiando)
    }
    }
}