package com.example.lab4general2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv: RecyclerView = findViewById(R.id.rvWorkers)
        rv.adapter = WorkersAdapter(generateWorkers(10))
        rv.layoutManager = LinearLayoutManager(this)
    }

    fun generateWorkers(size: Int): List<Worker> {
        val listOfImages = listOf(R.drawable.github, R.drawable.discord)
        val workers = mutableListOf<Worker>()
        for (i in 0..size) {
            workers.add(Worker("Номер $i", "Работник ", listOfImages.random()))
        }
        return workers
    }
}