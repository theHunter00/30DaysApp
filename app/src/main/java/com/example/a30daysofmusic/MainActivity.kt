package com.example.a30daysofmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Encontrar el RecyclerView en el layout
        val recyclerView: RecyclerView = findViewById(R.id.challenges_recycler_view)

        // 2. Crear una instancia de nuestro adaptador, pasándole la lista de datos
        val adapter = ChallengeAdapter(ChallengesRepository.challenges)

        // 3. Asignar el adaptador al RecyclerView
        recyclerView.adapter = adapter
    }
}