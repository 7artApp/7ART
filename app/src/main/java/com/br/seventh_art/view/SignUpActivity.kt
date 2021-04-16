package com.br.seventh_art.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.ui.login.Utils
import com.br.seventh_art.view.genres.MoviesGenresActivity

class SignUpActivity : AppCompatActivity(), Utils {

    private val username by lazy { findViewById<EditText>(R.id.username_sign_up) }
    private val emailSignUp by lazy { findViewById<EditText>(R.id.email_sign_up) }
    private val passwordSignUp by lazy { findViewById<EditText>(R.id.password_sign_up) }
    private val confirmPassword by lazy { findViewById<EditText>(R.id.confirm_password)}
    private val buttonLogIn by lazy { findViewById<Button>(R.id.button_sign_up)}
    private val buttonBack by lazy {findViewById<ImageButton>(R.id.button_back_sign_up)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initClick()
    }

    private fun initClick() {
        buttonLogIn.setOnClickListener{
            if(validateName(username) && validateEmail(emailSignUp) && validatePassword(passwordSignUp) && validateConfirmPassword(passwordSignUp,confirmPassword)){
                val intent = Intent(this,
                    MoviesGenresActivity::class.java)
                startActivity(intent)
            }
        }

        buttonBack.setOnClickListener{
            onBackPressed()
        }
    }
}