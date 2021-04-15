package com.br.seventh_art.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.br.seventh_art.R

class ProfileActivity : AppCompatActivity() {

    private val buttonBack by lazy { findViewById<Button>(R.id.button_back_profile) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initClick()
    }

    private fun initClick() {
        buttonBack.setOnClickListener(){
            onBackPressed()
        }
    }
}