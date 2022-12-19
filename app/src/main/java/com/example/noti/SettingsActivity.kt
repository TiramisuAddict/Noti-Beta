package com.example.noti

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import java.util.*



class SettingsActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val applyB = findViewById<Button>(R.id.applyButton)
        val saveB = findViewById<Button>(R.id.saveB)

        fun loadThemeData():Boolean{

            val sharedPrefrences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
            val savedBoolenn = sharedPrefrences.getBoolean("LastThemeOption",true)

            return(savedBoolenn)
        }

        val DwSwitch = findViewById<Switch>(R.id.DmSwitch)
        var checkBoxDefaultState = true
        DwSwitch.isChecked = loadThemeData()

        fun saveThemeData(){
            val sharedPrefrences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
            val editor = sharedPrefrences.edit()

            editor.apply{
                putBoolean("LastThemeOption" , checkBoxDefaultState)
            }.apply()

        }

        applyB.setOnClickListener{

            if(DwSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                checkBoxDefaultState = true
                saveThemeData()
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                checkBoxDefaultState = false
                saveThemeData()
            }

        }

        saveB.setOnClickListener{
            startActivity(Intent(this@SettingsActivity , MainActivity::class.java))
        }

    }


}