package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var inicio = findViewById<Button>(R.id.start);


        inicio.setOnClickListener {
            val cambiando= Intent(this,menu::class.java)
            startActivity(cambiando)
        }
    }
}