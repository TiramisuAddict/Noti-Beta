package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible

class SeconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon)

        val b1 = findViewById<Button>(R.id.b1ere)
        val b2 = findViewById<Button>(R.id.b2eme)
        val b3 = findViewById<Button>(R.id.b3eme)
        val b4 = findViewById<Button>(R.id.b4eme)

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        // 1 ere (Direct Link)

        b1.setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCp::class.java))
            pg.isVisible = true
        }

        // 2 eme (Link)

        b2.setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal2::class.java))
        }

        // 3 eme (Link)

        b3.setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal3::class.java))
        }

        // 4 eme (Link)

        b4.setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal4::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        pg.isVisible = false
    }

}