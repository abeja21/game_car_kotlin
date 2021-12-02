package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle




class juego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        var partida=Race(Jugadores_coches, circuito_seleccionado)
    }

}