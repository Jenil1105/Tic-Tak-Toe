package com.example.sunchokdi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class players : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_players)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resetButton = findViewById<Button>(R.id.reset)
        val startButton = findViewById<Button>(R.id.go)
        val player1 = findViewById<EditText>(R.id.player1)
        val player2 = findViewById<EditText>(R.id.player2)


        resetButton.setOnClickListener {
            finish()
        }
        startButton.setOnClickListener {
                val player1Name = player1.text.toString()
                val player2Name = player2.text.toString()

                val main = Intent(this@players, MainActivity::class.java)
                main.putExtra("player1", player1Name)
                main.putExtra("player2", player2Name)
                startActivity(main)

        }
    }
}