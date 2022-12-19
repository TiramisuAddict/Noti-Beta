package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible

class PrepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prep)

        val b7 = findViewById<Button>(R.id.b7eme)
        val b8 = findViewById<Button>(R.id.b8eme)
        val b9 = findViewById<Button>(R.id.b9eme)

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        b7.setOnClickListener {
            startActivity(Intent(this@PrepActivity , PrepActivityCal7::class.java))
            pg.isVisible = true
        }

        b8.setOnClickListener {
            startActivity(Intent(this@PrepActivity , PrepActivityCal8::class.java))
            pg.isVisible = true
        }

        b9.setOnClickListener {
            startActivity(Intent(this@PrepActivity , PrepActivityCal9::class.java))
            pg.isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        pg.isVisible = false
    }
}