package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.droidsonroids.gif.GifImageView

class ver_coches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_coches)
        val ArrayCoches= mutableListOf<Cars>();
        val coche1=Cars("octane",70,6,3,90,"R.drawable.car1","@drawable/fondo_coche1")
        ArrayCoches.add(coche1)
        var gifcoche=findViewById<GifImageView>(R.id.car1)


    }
}




