package com.example.sunchokdi

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Winner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val winnerTextView = findViewById<TextView>(R.id.winnerTextView)
        val bg = findViewById<LinearLayout>(R.id.bgLayout)

        val winner = intent.getStringExtra("Winner")?:"No winner"
        winnerTextView.text = winner

        if(winner=="Winner is:X"){
            bg.background= resources.getDrawable(R.drawable.chokdi)
        }else if(winner=="Winner is:O"){
            bg.background= resources.getDrawable(R.drawable.sun)
        }else{
            bg.background = resources.getDrawable(R.drawable.both)
        }

        val playAgainButton = findViewById<TextView>(R.id.restrartButton)
        playAgainButton.setOnClickListener {
            finish()
        }

    }
}
