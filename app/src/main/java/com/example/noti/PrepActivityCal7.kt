package com.example.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.math.BigDecimal
import java.math.RoundingMode

class PrepActivityCal7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prep_cal7)

        // : ## Average Functions ## :

        // MoyenneDe2 : (2)
        fun MoyenneDe2 (ctr : Float , synt : Float ) : String{
            val resi = BigDecimal( ( (ctr+(synt*2) ) /3).toDouble() ).setScale(2, RoundingMode.HALF_EVEN)
            return resi.toString()
        }

        // MoyenneDe3 : (3) (Standard)
        fun MoyenneDe3 (ctr1 : Float , ctr2 :Float , synt : Float ) : String{
            val resi = BigDecimal( ( (ctr1+ctr2+(synt*2) ) /4).toDouble() ).setScale(2, RoundingMode.HALF_EVEN)
            return resi.toString()
        }

        //MoyenneDe4 : (4) (Fr)
        fun MoyenneDe4 (orale : Float , ctr1 : Float , ctr2 :Float , synt : Float ) : String{
            val resi = BigDecimal( ( (orale + ctr1 + ctr2 + (synt*2) ) /5).toDouble() ).setScale(2, RoundingMode.HALF_EVEN)
            return resi.toString()
        }

        // MoyenneDe5 : (5) (Ar)
        fun MoyenneDe5 (orale : Float , ctr :Float , synt : Float , ctrmk :Float , syntmk : Float ) : String{
            val resi = BigDecimal( ( ( ( (ctr+(synt*2) ) /3) + ( (ctrmk+(syntmk*2) )/3) *2 + orale) /4).toDouble()).setScale(2, RoundingMode.HALF_EVEN)
            return resi.toString()
        }

        // : ## Realtime Checking Functions ## :

        //For Calculating stuff with normal stuff (3) (Standard)
        fun RealtimeCheck3 (targetX : TextInputEditText, nf1 : TextInputLayout, nf2 : TextInputLayout, nfx : TextInputLayout,
                  ng1 : TextInputEditText, ng2 : TextInputEditText, ngx : TextInputEditText, nxr : TextView){

            targetX.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (ng1.text.toString() == "" || ng2.text.toString() == "" || ngx.text.toString() == ""){
                        nxr.text = getString(R.string._00_00)
                    }
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    if (ng1.text.toString() != "" && ng2.text.toString() != "" && ngx.text.toString() != ""){

                        //executing the calculating function(s)
                        nxr.text = MoyenneDe3( ng1.text.toString().toFloat() , ng2.text.toString().toFloat() , ngx.text.toString().toFloat())

                        //EditTexts restrictions
                        if (ng1.text.toString().length > 5 || ng1.text.toString().toFloat() > 20){
                            nf1.error = "_"
                        }else{
                            nf1.error = null
                        }

                        if (ng2.text.toString().length > 5 || ng2.text.toString().toFloat() > 20){
                            nf2.error = "_"
                        }else if(ng2.text.toString().length <= 5 && ng2.text.toString().toFloat() <= 20){
                            nf2.error = null
                        }

                        if (ngx.text.toString().length > 5 || ngx.text.toString().toFloat() > 20){
                            nfx.error = "_"
                        }else if(ngx.text.toString().length <= 5 && ngx.text.toString().toFloat() <= 20){
                            nfx.error = null
                        }

                    }
                }
            })

        }

        //For Calculating stuff with stuff (4)
        fun RealtimeCheck4 (targetX : TextInputEditText, orf : TextInputLayout , nf1 : TextInputLayout, nf2 : TextInputLayout, nfx : TextInputLayout,
                            org : TextInputEditText , ng1 : TextInputEditText, ng2 : TextInputEditText, ngx : TextInputEditText, nxr : TextView){

            targetX.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (ng1.text.toString() == "" || ng2.text.toString() == "" || org.text.toString() == "" || ngx.text.toString() == ""){
                        nxr.text = getString(R.string._00_00)
                    }
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    if (ng1.text.toString() != "" && ng2.text.toString() != "" && ngx.text.toString() != ""){

                        //executing the calculating function(s)
                        nxr.text = MoyenneDe4(org.text.toString().toFloat() , ng1.text.toString().toFloat() , ng2.text.toString().toFloat() , ngx.text.toString().toFloat())

                        //EditTexts restrictions

                        if (org.text.toString().length > 5 || org.text.toString().toFloat() > 20){
                            orf.error = "_"
                        }else if(org.text.toString().length <= 5 && org.text.toString().toFloat() <= 20){
                            orf.error = null
                        }

                        if (ng1.text.toString().length > 5 || ng1.text.toString().toFloat() > 20){
                            nf1.error = "_"
                        }else if(ng1.text.toString().length <= 5 && ng1.text.toString().toFloat() <= 20){
                            nf1.error = null
                        }

                        if (ng2.text.toString().length > 5 || ng2.text.toString().toFloat() > 20){
                            nf2.error = "_"
                        }else if(ng2.text.toString().length <= 5 && ng2.text.toString().toFloat() <= 20){
                            nf2.error = null
                        }

                        if (ngx.text.toString().length > 5 || ngx.text.toString().toFloat() > 20){
                            nfx.error = "_"
                        }else if(ngx.text.toString().length <= 5 && ngx.text.toString().toFloat() <= 20){
                            nfx.error = null
                        }

                    }
                }
            })

        }

        //For Calculating stuff with stuff (2)
        fun RealtimeCheck2 (targetX : TextInputEditText, nf : TextInputLayout, nfx : TextInputLayout,
                   ng : TextInputEditText, ngx : TextInputEditText, nxr : TextView){

            targetX.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (ng.text.toString() == "" || ngx.text.toString() == ""){
                        nxr.text = getString(R.string._00_00)
                    }
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    if (ng.text.toString()  != "" && ngx.text.toString() != ""){

                        //executing the calculating function(s)
                        nxr.text = MoyenneDe2(ng.text.toString().toFloat() , ngx.text.toString().toFloat())

                        //EditTexts restrictions
                        if (ng.text.toString().length > 5 || ng.text.toString().toFloat() > 20){
                            nf.error = "_"
                        }else if(ng.text.toString().length <= 5 && ng.text.toString().toFloat() <= 20){
                            nf.error = null
                        }

                        if (ngx.text.toString().length > 5 || ngx.text.toString().toFloat() > 20){
                            nfx.error = "_"
                        }else if(ngx.text.toString().length <= 5 && ngx.text.toString().toFloat() <= 20){
                            nfx.error = null
                        }
                    }
                }
            })

        }

        //For Calculating stuff with stuff (5)
        fun RealtimeCheck5 (targetX : TextInputEditText, nf1 : TextInputLayout, nf2 : TextInputLayout, nf3 : TextInputLayout, nf4 : TextInputLayout, nf5 : TextInputLayout,
                   ng1 : TextInputEditText, ng2 : TextInputEditText, ng3 : TextInputEditText, ng4 : TextInputEditText, ng5 : TextInputEditText, nxr : TextView){

            targetX.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (ng1.text.toString() == "" || ng2.text.toString() == "" || ng3.text.toString() == "" || ng4.text.toString() == "" || ng5.text.toString() == ""){
                        nxr.text = getString(R.string._00_00)
                    }
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    if (ng1.text.toString() != "" && ng2.text.toString() != "" && ng3.text.toString() != "" && ng4.text.toString() != "" && ng5.text.toString() != ""){

                        //executing the calculating function(s)
                        nxr.text = MoyenneDe5( ng1.text.toString().toFloat() , ng2.text.toString().toFloat() , ng3.text.toString().toFloat() , ng4.text.toString().toFloat() , ng5.text.toString().toFloat())

                        //EditTexts restrictions
                        if (ng1.text.toString().length > 5 || ng1.text.toString().toFloat() > 20){
                            nf1.error = "_"
                        }else if(ng1.text.toString().length <= 5 && ng1.text.toString().toFloat() <= 20){
                            nf1.error = null
                        }

                        if (ng2.text.toString().length > 5 || ng2.text.toString().toFloat() > 20){
                            nf2.error = "_"
                        }else if(ng2.text.toString().length <= 5 && ng2.text.toString().toFloat() <= 20){
                            nf2.error = null
                        }

                        if (ng3.text.toString().length > 5 || ng3.text.toString().toFloat() > 20){
                            nf3.error = "_"
                        }else if(ng3.text.toString().length <= 5 && ng3.text.toString().toFloat() <= 20){
                            nf3.error = null
                        }

                        if (ng4.text.toString().length > 5 || ng4.text.toString().toFloat() > 20){
                            nf4.error = "_"
                        }else if(ng4.text.toString().length <= 5 && ng4.text.toString().toFloat() <= 20){
                            nf4.error = null
                        }

                        if (ng5.text.toString().length > 5 || ng5.text.toString().toFloat() > 20){
                            nf5.error = "_"
                        }else if(ng5.text.toString().length <= 5 && ng5.text.toString().toFloat() <= 20){
                            nf5.error = null
                        }

                    }
                }
            })

        }

        //Arabic
        val n1_orale = findViewById<TextInputLayout>(R.id.n1_orale)
        val n1ctr1 = findViewById<TextInputLayout>(R.id.n1_ctr1)
        val n1synt = findViewById<TextInputLayout>(R.id.n1_synt)
        val n1ctr1mk = findViewById<TextInputLayout>(R.id.n1_ctr1mk)
        val n1syntmk = findViewById<TextInputLayout>(R.id.n1_syntmk)

        val n1orale = findViewById<TextInputEditText>(R.id.n1orale)
        val n1c1 = findViewById<TextInputEditText>(R.id.n1c1)
        val n1s = findViewById<TextInputEditText>(R.id.n1s)
        val n1c1mk = findViewById<TextInputEditText>(R.id.n1c1mk)
        val n1smk = findViewById<TextInputEditText>(R.id.n1smk)

        val n1res = findViewById<TextView>(R.id.n1_res)

        RealtimeCheck5(n1orale , n1_orale , n1ctr1 , n1synt ,n1ctr1mk ,n1syntmk ,n1orale , n1c1 , n1s , n1c1mk , n1smk , n1res)
        RealtimeCheck5(n1c1 , n1_orale , n1ctr1 , n1synt ,n1ctr1mk ,n1syntmk ,n1orale , n1c1 , n1s , n1c1mk , n1smk , n1res)
        RealtimeCheck5(n1s , n1_orale , n1ctr1 , n1synt ,n1ctr1mk ,n1syntmk ,n1orale , n1c1 , n1s , n1c1mk , n1smk , n1res)
        RealtimeCheck5(n1c1mk , n1_orale , n1ctr1 , n1synt ,n1ctr1mk ,n1syntmk ,n1orale , n1c1 , n1s , n1c1mk , n1smk , n1res)
        RealtimeCheck5(n1smk , n1_orale , n1ctr1 , n1synt ,n1ctr1mk ,n1syntmk ,n1orale , n1c1 , n1s , n1c1mk , n1smk , n1res)


        //French (2)
        val n2_or = findViewById<TextInputLayout>(R.id.n2_or)
        val n2ctr1 = findViewById<TextInputLayout>(R.id.n2_ctr1)
        val n2ctr2 = findViewById<TextInputLayout>(R.id.n2_ctr2)
        val n2synt = findViewById<TextInputLayout>(R.id.n2_synt)

        val n2or = findViewById<TextInputEditText>(R.id.n2or)
        val n2c1 = findViewById<TextInputEditText>(R.id.n2c1)
        val n2c2 = findViewById<TextInputEditText>(R.id.n2c2)
        val n2s = findViewById<TextInputEditText>(R.id.n2s)

        val n2res = findViewById<TextView>(R.id.n2_res)

        RealtimeCheck4(n2or , n2_or , n2ctr1 , n2ctr2 , n2synt , n2or , n2c1 , n2c2 , n2s , n2res)
        RealtimeCheck4(n2c1 , n2_or , n2ctr1 , n2ctr2 , n2synt , n2or , n2c1 , n2c2 , n2s , n2res)
        RealtimeCheck4(n2c2 , n2_or , n2ctr1 , n2ctr2 , n2synt , n2or , n2c1 , n2c2 , n2s , n2res)
        RealtimeCheck4(n2s , n2_or , n2ctr1 , n2ctr2 , n2synt , n2or , n2c1 , n2c2 , n2s , n2res)

        //English (3)
        val n3ctr1 = findViewById<TextInputLayout>(R.id.n3_ctr1)
        val n3ctr2 = findViewById<TextInputLayout>(R.id.n3_ctr2)
        val n3synt = findViewById<TextInputLayout>(R.id.n3_synt)

        val n3c1 = findViewById<TextInputEditText>(R.id.n3c1)
        val n3c2 = findViewById<TextInputEditText>(R.id.n3c2)
        val n3s = findViewById<TextInputEditText>(R.id.n3s)

        val n3res = findViewById<TextView>(R.id.n3_res)

        RealtimeCheck3(n3c1 , n3ctr1 , n3ctr2 , n3synt , n3c1 , n3c2 , n3s , n3res)
        RealtimeCheck3(n3c2 , n3ctr1 , n3ctr2 , n3synt , n3c1 , n3c2 , n3s , n3res)
        RealtimeCheck3(n3s , n3ctr1 , n3ctr2 , n3synt , n3c1 , n3c2 , n3s , n3res)

        //History (4)
        val n4ctr1 = findViewById<TextInputLayout>(R.id.n4_ctr1)
        val n4ctr2 = findViewById<TextInputLayout>(R.id.n4_ctr2)
        val n4synt = findViewById<TextInputLayout>(R.id.n4_synt)

        val n4c1 = findViewById<TextInputEditText>(R.id.n4c1)
        val n4c2 = findViewById<TextInputEditText>(R.id.n4c2)
        val n4s = findViewById<TextInputEditText>(R.id.n4s)

        val n4res = findViewById<TextView>(R.id.n4_res)

        RealtimeCheck3(n4c1 , n4ctr1 , n4ctr2 , n4synt , n4c1 , n4c2 , n4s , n4res)
        RealtimeCheck3(n4c2 , n4ctr1 , n4ctr2 , n4synt , n4c1 , n4c2 , n4s , n4res)
        RealtimeCheck3(n4s , n4ctr1 , n4ctr2 , n4synt , n4c1 , n4c2 , n4s , n4res)

        //Geography (5)
        val n5ctr1 = findViewById<TextInputLayout>(R.id.n5_ctr1)
        val n5ctr2 = findViewById<TextInputLayout>(R.id.n5_ctr2)
        val n5synt = findViewById<TextInputLayout>(R.id.n5_synt)

        val n5c1 = findViewById<TextInputEditText>(R.id.n5c1)
        val n5c2 = findViewById<TextInputEditText>(R.id.n5c2)
        val n5s = findViewById<TextInputEditText>(R.id.n5s)

        val n5res = findViewById<TextView>(R.id.n5_res)

        RealtimeCheck3(n5c1 , n5ctr1 , n5ctr2 , n5synt , n5c1 , n5c2 , n5s , n5res)
        RealtimeCheck3(n5c2 , n5ctr1 , n5ctr2 , n5synt , n5c1 , n5c2 , n5s , n5res)
        RealtimeCheck3(n5s , n5ctr1 , n5ctr2 , n5synt , n5c1 , n5c2 , n5s , n5res)

        //Islamic Thinking (6)
        val n6ctr1 = findViewById<TextInputLayout>(R.id.n6_ctr1)
        val n6ctr2 = findViewById<TextInputLayout>(R.id.n6_ctr2)
        val n6synt = findViewById<TextInputLayout>(R.id.n6_synt)

        val n6c1 = findViewById<TextInputEditText>(R.id.n6c1)
        val n6c2 = findViewById<TextInputEditText>(R.id.n6c2)
        val n6s = findViewById<TextInputEditText>(R.id.n6s)

        val n6res = findViewById<TextView>(R.id.n6_res)

        RealtimeCheck3(n6c1 , n6ctr1 , n6ctr2 , n6synt , n6c1 , n6c2 , n6s , n6res)
        RealtimeCheck3(n6c2 , n6ctr1 , n6ctr2 , n6synt , n6c1 , n6c2 , n6s , n6res)
        RealtimeCheck3(n6s , n6ctr1 , n6ctr2 , n6synt , n6c1 , n6c2 , n6s , n6res)

        //Civic Education (7)
        val n7ctr1 = findViewById<TextInputLayout>(R.id.n7_ctr1)
        val n7ctr2 = findViewById<TextInputLayout>(R.id.n7_ctr2)
        val n7synt = findViewById<TextInputLayout>(R.id.n7_synt)

        val n7c1 = findViewById<TextInputEditText>(R.id.n7c1)
        val n7c2 = findViewById<TextInputEditText>(R.id.n7c2)
        val n7s = findViewById<TextInputEditText>(R.id.n7s)

        val n7res = findViewById<TextView>(R.id.n7_res)

        RealtimeCheck3(n7c1 , n7ctr1 , n7ctr2 , n7synt , n7c1 , n7c2 , n7s , n7res)
        RealtimeCheck3(n7c2 , n7ctr1 , n7ctr2 , n7synt , n7c1 , n7c2 , n7s , n7res)
        RealtimeCheck3(n7s , n7ctr1 , n7ctr2 , n7synt , n7c1 , n7c2 , n7s , n7res)

        //Maths (8)
        val n8ctr1 = findViewById<TextInputLayout>(R.id.n8_ctr1)
        val n8ctr2 = findViewById<TextInputLayout>(R.id.n8_ctr2)
        val n8synt = findViewById<TextInputLayout>(R.id.n8_synt)

        val n8c1 = findViewById<TextInputEditText>(R.id.n8c1)
        val n8c2 = findViewById<TextInputEditText>(R.id.n8c2)
        val n8s = findViewById<TextInputEditText>(R.id.n8s)

        val n8res = findViewById<TextView>(R.id.n8_res)

        RealtimeCheck3(n8c1 , n8ctr1 , n8ctr2 , n8synt , n8c1 , n8c2 , n8s , n8res)
        RealtimeCheck3(n8c2 , n8ctr1 , n8ctr2 , n8synt , n8c1 , n8c2 , n8s , n8res)
        RealtimeCheck3(n8s , n8ctr1 , n8ctr2 , n8synt , n8c1 , n8c2 , n8s , n8res)


        //Physics (9)
        val n9ctr1 = findViewById<TextInputLayout>(R.id.n9_ctr1)
        val n9synt = findViewById<TextInputLayout>(R.id.n9_synt)

        val n9c1 = findViewById<TextInputEditText>(R.id.n9c1)
        val n9s = findViewById<TextInputEditText>(R.id.n9s)

        val n9res = findViewById<TextView>(R.id.n9_res)

        RealtimeCheck2(n9c1 , n9ctr1 , n9synt , n9c1 , n9s , n9res)
        RealtimeCheck2(n9s , n9ctr1 , n9synt , n9c1 , n9s , n9res)

        //Life and earth sciences (10)
        val n10ctr1 = findViewById<TextInputLayout>(R.id.n10_ctr1)
        val n10ctr2 = findViewById<TextInputLayout>(R.id.n10_ctr2)
        val n10synt = findViewById<TextInputLayout>(R.id.n10_synt)

        val n10c1 = findViewById<TextInputEditText>(R.id.n10c1)
        val n10c2 = findViewById<TextInputEditText>(R.id.n10c2)
        val n10s = findViewById<TextInputEditText>(R.id.n10s)

        val n10res = findViewById<TextView>(R.id.n10_res)

        RealtimeCheck3(n10c1 , n10ctr1 , n10ctr2 , n10synt , n10c1 , n10c2 , n10s , n10res)
        RealtimeCheck3(n10c2 , n10ctr1 , n10ctr2 , n10synt , n10c1 , n10c2 , n10s , n10res)
        RealtimeCheck3(n10s , n10ctr1 , n10ctr2 , n10synt , n10c1 , n10c2 , n10s , n10res)

        //Technology (11)
        val n11ctr1 = findViewById<TextInputLayout>(R.id.n11_ctr1)
        val n11ctr2 = findViewById<TextInputLayout>(R.id.n11_ctr2)
        val n11synt = findViewById<TextInputLayout>(R.id.n11_synt)

        val n11c1 = findViewById<TextInputEditText>(R.id.n11c1)
        val n11c2 = findViewById<TextInputEditText>(R.id.n11c2)
        val n11s = findViewById<TextInputEditText>(R.id.n11s)

        val n11res = findViewById<TextView>(R.id.n11_res)

        RealtimeCheck3(n11c1 , n11ctr1 , n11ctr2 , n11synt , n11c1 , n11c2 , n11s , n11res)
        RealtimeCheck3(n11c2 , n11ctr1 , n11ctr2 , n11synt , n11c1 , n11c2 , n11s , n11res)
        RealtimeCheck3(n11s , n11ctr1 , n11ctr2 , n11synt , n11c1 , n11c2 , n11s , n11res)

        //Information Technology (12)
        val n12ctr1 = findViewById<TextInputLayout>(R.id.n12_ctr1)
        val n12synt = findViewById<TextInputLayout>(R.id.n12_synt)

        val n12c1 = findViewById<TextInputEditText>(R.id.n12c1)
        val n12s = findViewById<TextInputEditText>(R.id.n12s)

        val n12res = findViewById<TextView>(R.id.n12_res)

        RealtimeCheck2(n12c1 , n12ctr1 , n12synt , n12c1 , n12s , n12res)
        RealtimeCheck2(n12s , n12ctr1 , n12synt , n12c1 , n12s , n12res)

        //Sport (13)
        val n13ctr1 = findViewById<TextInputLayout>(R.id.n13_ctr1)
        val n13synt = findViewById<TextInputLayout>(R.id.n13_synt)

        val n13c1 = findViewById<TextInputEditText>(R.id.n13c1)
        val n13s = findViewById<TextInputEditText>(R.id.n13s)

        val n13res = findViewById<TextView>(R.id.n13_res)

        RealtimeCheck2(n13c1 , n13ctr1 , n13synt , n13c1 , n13s , n13res)
        RealtimeCheck2(n13s , n13ctr1 , n13synt , n13c1 , n13s , n13res)

        val checkBoxSport = findViewById<CheckBox>(R.id.SportCheckBox)

        checkBoxSport.setOnClickListener {
            //in case the checkbox is checked
            if (checkBoxSport.isChecked){
                n13ctr1.isEnabled = false
                n13synt.isEnabled = false
                n13res.text = getString(R.string.exempt_)
            }else{ //in case the checkbox is not checked
                n13ctr1.isEnabled = true
                n13synt.isEnabled = true
                if (n13c1.text.toString() == "" && n13s.text.toString() == ""){
                    n13res.text = getString(R.string.ResetCounter) //setting the value to 00.00
                }else if (n13c1.text.toString() != "" && n13s.text.toString() != ""){
                    n13res.text = MoyenneDe2(n13c1.text.toString().toFloat() , n13s.text.toString().toFloat())
                }else{
                    n13res.text = getString(R.string.ResetCounter) //setting the value to 00.00
                }
            }
        }
        
        //Music (14)
        val n14ctr1 = findViewById<TextInputLayout>(R.id.n14_ctr1)
        val n14synt = findViewById<TextInputLayout>(R.id.n14_synt)

        val n14c1 = findViewById<TextInputEditText>(R.id.n14c1)
        val n14s = findViewById<TextInputEditText>(R.id.n14s)

        val n14res = findViewById<TextView>(R.id.n14_res)

        RealtimeCheck2(n14c1 , n14synt , n14ctr1 , n14s , n14c1 , n14res)
        RealtimeCheck2(n14s , n14synt , n14ctr1 , n14s , n14c1 , n14res)

        //Arts (15)
        val n15ctr1 = findViewById<TextInputLayout>(R.id.n15_ctr1)
        val n15synt = findViewById<TextInputLayout>(R.id.n15_synt)

        val n15c1 = findViewById<TextInputEditText>(R.id.n15c1)
        val n15s = findViewById<TextInputEditText>(R.id.n15s)

        val n15res = findViewById<TextView>(R.id.n15_res)

        RealtimeCheck2(n15c1 , n15ctr1 , n15synt , n15c1 , n15s , n15res)
        RealtimeCheck2(n15s , n15ctr1 , n15synt , n15c1 , n15s , n15res)

        //joey tribbiani (HOW U DOINNN ;) !! ) (16)
        val n16ctr1 = findViewById<TextInputLayout>(R.id.n16_ctr1)
        val n16synt = findViewById<TextInputLayout>(R.id.n16_synt)

        val n16c1 = findViewById<TextInputEditText>(R.id.n16c1)
        val n16s = findViewById<TextInputEditText>(R.id.n16s)

        val n16res = findViewById<TextView>(R.id.n16_res)

        RealtimeCheck2(n16c1 , n16ctr1 , n16synt , n16c1 , n16s , n16res)
        RealtimeCheck2(n16s , n16ctr1 , n16synt , n16c1 , n16s , n16res)

        val checkBoxThea = findViewById<CheckBox>(R.id.TheatriCheckBox)

        checkBoxThea.setOnClickListener {
            //in case the checkbox is checked
            if (checkBoxThea.isChecked){
                n16ctr1.isEnabled = false
                n16synt.isEnabled = false
                n16res.text = getString(R.string.exempt_)
            }else{ //in case the checkbox is not checked
                n16ctr1.isEnabled = true
                n16synt.isEnabled = true
                if (n16c1.text.toString() == "" && n16s.text.toString() == ""){
                    n16res.text = getString(R.string.ResetCounter) //setting the value to 00.00
                }else if (n16c1.text.toString() != "" && n16s.text.toString() != ""){
                    n16res.text = MoyenneDe2(n16c1.text.toString().toFloat() , n16s.text.toString().toFloat())
                }else{
                    n16res.text = getString(R.string.ResetCounter) //setting the value to 00.00
                }
            }
        }

        //precalculating phase (Stable)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {

            if (!checkBoxThea.isChecked && !checkBoxSport.isChecked){ //Exempt --> Sport #--False--# || Theatre #--False--#
                val CalculationResult= ((n1res.text.toString().toFloat() * 4) + (n2res.text.toString().toFloat() * 4)  + (n3res.text.toString().toFloat() *1.5)  + (n4res.text.toString().toFloat() *1)  + (n5res.text.toString().toFloat() *1)  + (n6res.text.toString().toFloat() *1)  + (n7res.text.toString().toFloat() *1)  + (n8res.text.toString().toFloat() *3)  + (n9res.text.toString().toFloat() *1) +  (n10res.text.toString().toFloat() *1) + (n11res.text.toString().toFloat() *1) + (n12res.text.toString().toFloat() *1) + (n13res.text.toString().toFloat() *1) + (n14res.text.toString().toFloat() *1) + (n15res.text.toString().toFloat() *1) + (n16res.text.toString().toFloat() *1)) / 24.5
                val R_CalculationResult = BigDecimal(CalculationResult.toFloat().toDouble()).setScale(2, RoundingMode.HALF_EVEN)
                val FinalResult = R_CalculationResult.toString()

                startActivity(
                    Intent(this@PrepActivityCal7, ResActivity::class.java).putExtra("Moy" ,FinalResult)
                )
            }else if (checkBoxThea.isChecked && !checkBoxSport.isChecked){//Exempt --> Sport #--False--# || Theatre #--True--#
                val CalculationResult= ((n1res.text.toString().toFloat() * 4) + (n2res.text.toString().toFloat() * 4)  + (n3res.text.toString().toFloat() *1.5)  + (n4res.text.toString().toFloat() *1)  + (n5res.text.toString().toFloat() *1)  + (n6res.text.toString().toFloat() *1)  + (n7res.text.toString().toFloat() *1)  + (n8res.text.toString().toFloat() *3)  + (n9res.text.toString().toFloat() *1) +  (n10res.text.toString().toFloat() *1) + (n11res.text.toString().toFloat() *1) + (n12res.text.toString().toFloat() *1) + (n13res.text.toString().toFloat() *1) + (n14res.text.toString().toFloat() *1) + (n15res.text.toString().toFloat() *1) ) / 23.5
                val R_CalculationResult = BigDecimal(CalculationResult.toFloat().toDouble()).setScale(2, RoundingMode.HALF_EVEN)
                val FinalResult = R_CalculationResult.toString()

                startActivity(
                    Intent(this@PrepActivityCal7, ResActivity::class.java).putExtra("Moy" ,FinalResult)
                )
            }else if (!checkBoxThea.isChecked && checkBoxSport.isChecked){//Exempt --> Sport #--True--# || Theatre #--False--#
                val CalculationResult= ((n1res.text.toString().toFloat() * 4) + (n2res.text.toString().toFloat() * 4)  + (n3res.text.toString().toFloat() *1.5)  + (n4res.text.toString().toFloat() *1)  + (n5res.text.toString().toFloat() *1)  + (n6res.text.toString().toFloat() *1)  + (n7res.text.toString().toFloat() *1)  + (n8res.text.toString().toFloat() *3)  + (n9res.text.toString().toFloat() *1) +  (n10res.text.toString().toFloat() *1) + (n11res.text.toString().toFloat() *1) + (n12res.text.toString().toFloat() *1) + (n14res.text.toString().toFloat() *1) + (n15res.text.toString().toFloat() *1) + (n16res.text.toString().toFloat() *1) ) / 23.5
                val R_CalculationResult = BigDecimal(CalculationResult.toFloat().toDouble()).setScale(2, RoundingMode.HALF_EVEN)
                val FinalResult = R_CalculationResult.toString()

                startActivity(
                    Intent(this@PrepActivityCal7, ResActivity::class.java).putExtra("Moy" ,FinalResult)
                )
            }else{ //Exempt --> Sport #--True--# || Theatre #--True--#
                val CalculationResult= ((n1res.text.toString().toFloat() * 4) + (n2res.text.toString().toFloat() * 4)  + (n3res.text.toString().toFloat() *1.5)  + (n4res.text.toString().toFloat() *1)  + (n5res.text.toString().toFloat() *1)  + (n6res.text.toString().toFloat() *1)  + (n7res.text.toString().toFloat() *1)  + (n8res.text.toString().toFloat() *3)  + (n9res.text.toString().toFloat() *1) +  (n10res.text.toString().toFloat() *1) + (n11res.text.toString().toFloat() *1) + (n12res.text.toString().toFloat() *1) + (n14res.text.toString().toFloat() *1) + (n15res.text.toString().toFloat() *1)) / 22.5
                val R_CalculationResult = BigDecimal(CalculationResult.toFloat().toDouble()).setScale(2, RoundingMode.HALF_EVEN)
                val FinalResult = R_CalculationResult.toString()

                startActivity(
                    Intent(this@PrepActivityCal7, ResActivity::class.java).putExtra("Moy" ,FinalResult)
                )
            }

        }

    }
}