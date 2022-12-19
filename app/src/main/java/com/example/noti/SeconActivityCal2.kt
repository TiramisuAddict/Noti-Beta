package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible

class SeconActivityCal2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal2)

        val bsc2 = findViewById<Button>(R.id.bsc2)
        val ble2 = findViewById<Button>(R.id.ble2)
        val bin2 = findViewById<Button>(R.id.bin2)
        val bec2 = findViewById<Button>(R.id.bec2)

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        bsc2.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , SeconActivityCal2_sc::class.java))
            pg.isVisible = true
        }

        ble2.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , SeconActivityCal2_le::class.java))
            pg.isVisible = true
        }

        bin2.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , SeconActivityCal2_in::class.java))
            pg.isVisible = true
        }

        bec2.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , SeconActivityCal2_ec::class.java))
            pg.isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        pg.isVisible = false
    }

}