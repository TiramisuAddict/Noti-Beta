package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible

class SeconActivityCal3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal3)

        val bsc3 = findViewById<Button>(R.id.bsc3)
        val bma3 = findViewById<Button>(R.id.bma3)
        val ble3 = findViewById<Button>(R.id.ble3)
        val bin3 = findViewById<Button>(R.id.bin3)
        val bte3 = findViewById<Button>(R.id.bte3)
        val bec3 = findViewById<Button>(R.id.bec3)

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        bsc3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_sc::class.java))
            pg.isVisible = true
        }

        bma3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_ma::class.java))
            pg.isVisible = true
        }

        ble3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_le::class.java))
            pg.isVisible = true
        }

        bin3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_in::class.java))
            pg.isVisible = true
        }

        bte3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_te::class.java))
            pg.isVisible = true
        }

        bec3.setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , SeconActivityCal3_ec::class.java))
            pg.isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()

        val pg = findViewById<ProgressBar>(R.id.progress_loader)

        pg.isVisible = false
    }

}