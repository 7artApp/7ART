package com.br.seventh_art.view

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.ui.login.Utils
import com.google.android.material.textfield.TextInputLayout

class SignInActivity: AppCompatActivity(), Utils {

    private val buttonLogin by lazy { findViewById<Button>(R.id.button_log_in) }
    private val emailSignIn by lazy { findViewById<EditText>(R.id.username_sign_in) }
    private val passwordSignIn by lazy { findViewById<EditText>(R.id.password_sign_in) }
    private val buttonBack by lazy { findViewById<Button>(R.id.button_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initClick()
    }

    private fun initClick() {
        buttonLogin.setOnClickListener {
            if (validatePassword(passwordSignIn) && validateEmail(emailSignIn)) {
                val intent = Intent(this, CategoryContentActivity::class.java)
                startActivity(intent)
            }

            buttonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}