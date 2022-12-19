package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CreditsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)

        val mB = findViewById<Button>(R.id.mButton)
        mB.setOnClickListener{
            startActivity(Intent(this@CreditsActivity , MainActivity::class.java))
        }
    }
}