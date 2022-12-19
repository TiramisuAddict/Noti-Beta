package com.example.noti

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun setTheme():Boolean{

            val sharedPrefrences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
            val savedBoolenn = sharedPrefrences.getBoolean("LastThemeOption",true)

            if(savedBoolenn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            return(savedBoolenn)
        }

        setTheme()

        val sB = findViewById<Button>(R.id.seconB)
        val pB = findViewById<Button>(R.id.prepaNB)
        val cB = findViewById<ImageButton>(R.id.creditsButton)

        cB.setOnClickListener{
            startActivity(Intent(this@MainActivity , CreditsActivity::class.java))
        }

        val SettinB = findViewById<Button>(R.id.settinButton)
        val haynoti = findViewById<TextView>(R.id.textView6)

        sB.setOnClickListener {
            startActivity(Intent(this@MainActivity , SeconActivity::class.java))
        }

        pB.setOnClickListener {
            startActivity(Intent(this@MainActivity , PrepActivity::class.java))
        }

        SettinB.setOnClickListener {
            startActivity(Intent(this@MainActivity , SettingsActivity::class.java))
        }

        fun loadData(){

            val sharedPrefrences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
            val savedString = sharedPrefrences.getString("STRING_KEY" , null)

            haynoti.text = savedString
        }

        loadData()

        if (haynoti.text.isNullOrEmpty()){
            haynoti.text = "00.00"
        }

    }


}