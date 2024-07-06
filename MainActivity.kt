package com.example.sunchokdi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sunchokdi.ui.theme.SunchokdiTheme
import android.view.View
import android.widget.Toast

class MainActivity : ComponentActivity() {
    private var flag = 0
    private var count = 0
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    private var b1: String = ""
    private var b2: String = ""
    private var b3: String = ""
    private var b4: String = ""
    private var b5: String = ""
    private var b6: String = ""
    private var b7: String = ""
    private var b8: String = ""
    private var b9: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstpage)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        // Example of setting a click listener to test the buttons
        btn1.setOnClickListener { check(it) }
        btn2.setOnClickListener { check(it) }
        btn3.setOnClickListener { check(it) }
        btn4.setOnClickListener { check(it) }
        btn5.setOnClickListener { check(it) }
        btn6.setOnClickListener { check(it) }
        btn7.setOnClickListener { check(it) }
        btn8.setOnClickListener { check(it) }
        btn9.setOnClickListener { check(it) }

    }

    public fun check(view: View) {
        val currb = view as Button
        if (flag == 0) {
            currb.text = "X"
            flag = 1
        } else {
            currb.text = "O"
            flag = 0
        }
        count++

        if (count > 4) {
            b1 = btn1.text.toString()
            b2 = btn2.text.toString()
            b3 = btn3.text.toString()
            b4 = btn4.text.toString()
            b5 = btn5.text.toString()
            b6 = btn6.text.toString()
            b7 = btn7.text.toString()
            b8 = btn8.text.toString()
            b9 = btn9.text.toString()

            if (b1 == b2 && b2 == b3 && b1.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_LONG).show()
                startWinnerActivity(b1)
                restrat()

            } else if (b4 == b5 && b5 == b6 && b4.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b4", Toast.LENGTH_LONG).show()
                startWinnerActivity(b4)
                restrat()
            } else if (b7 == b8 && b8 == b9 && b7.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b7", Toast.LENGTH_LONG).show()
                startWinnerActivity(b7)
                restrat()
            } else if (b1 == b4 && b4 == b7 && b1.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_LONG).show()
                startWinnerActivity(b1)
                restrat()
            } else if (b2 == b5 && b5 == b8 && b2.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b2", Toast.LENGTH_LONG).show()
                startWinnerActivity(b2)
                restrat()
            } else if (b3 == b6 && b6 == b9 && b3.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_LONG).show()
                startWinnerActivity(b3)
                restrat()
            } else if (b1 == b5 && b5 == b9 && b1.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_LONG).show()
                startWinnerActivity(b1)
                restrat()
            } else if (b3 == b5 && b5 == b7 && b3.isNotEmpty()) {
                Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_LONG).show()
                startWinnerActivity(b3)
                restrat()
            } else if( count == 9){
                startWinnerActivity("Draw")
                restrat()
            }

        }
    }

    public fun restrat(){

        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
        flag=0
        count=0

    }
    private fun startWinnerActivity(bx: String) {
        val next = Intent(this@MainActivity, Winner::class.java)

        // Retrieve intent extras here
        val win1: String = intent.getStringExtra("player1") ?: "Player 1"
        val win2: String = intent.getStringExtra("player2") ?: "Player 2"

        if (bx == "Draw") {
            next.putExtra("Winner", "Draw!!")
        } else if (bx == "X") {
            next.putExtra("Winner", "Winner: $win1")
        } else if (bx == "O") {
            next.putExtra("Winner", "Winner: $win2")
        }
        startActivity(next)
    }
}




