package com.example.noti

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        val ResultTextView = findViewById<TextView>(R.id.blaba)

        val result = intent.getStringExtra("Moy")

        ResultTextView.text = result

        val mNBa = findViewById<Button>(R.id.button2)

        val prevbut = findViewById<ImageButton>(R.id.prevbut)

        prevbut.setOnClickListener() {
            onBackPressed()
        }

        //adb
        val adb = findViewById<Button>(R.id.adb)
        adb.setOnClickListener() {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/lyceena-noti"))
            startActivity(i)
        }


        //SharedPrefrences Stuff

        fun saveData(){
            val sharedPrefrences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
            val editor = sharedPrefrences.edit()

            editor.apply{
                putString("STRING_KEY" , result)
            }.apply()
        }

        mNBa.setOnClickListener {
            this.finish()
            startActivity(Intent(this@ResActivity , MainActivity::class.java))
            saveData()
        }
    }


}