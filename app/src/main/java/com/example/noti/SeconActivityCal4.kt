package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible

class SeconActivityCal4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal4)

        val bsc4 = findViewById<Button>(R.id.bsc4)
        val bma4 = findViewById<Button>(R.id.bma4)
        val ble4 = findViewById<Button>(R.id.ble4)
        val bin4 = findViewById<Button>(R.id.bin4)
        val bte4 = findViewById<Button>(R.id.bte4)
        val bec4 = findViewById<Button>(R.id.bec4)

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        bsc4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_sc::class.java))
            pg.isVisible = true
        }

        bma4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_ma::class.java))
            pg.isVisible = true
        }

        ble4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_le::class.java))
            pg.isVisible = true
        }

        bin4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_in::class.java))
            pg.isVisible = true
        }

        bte4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_te::class.java))
            pg.isVisible = true
        }

        bec4.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , SeconActivityCal4_ec::class.java))
            pg.isVisible = true
        }
        
    }

    override fun onResume() {
        super.onResume()

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        pg.isVisible = false
    }

}