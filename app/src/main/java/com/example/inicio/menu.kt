package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var volver= findViewById<Button>(R.id.return1)
        var ver_coches=findViewById<Button>(R.id.ver_coches)
        var jugar=findViewById<Button>(R.id.jugar)

        volver.setOnClickListener {
            val cambiando= Intent(this,MainActivity::class.java)
            startActivity(cambiando)
        }


    }
}