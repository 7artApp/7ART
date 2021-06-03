package com.br.seventh_art.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.br.seventh_art.R
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private val imageProfile by lazy { findViewById<ImageView>(R.id.image_profile) }
    private val username by lazy { findViewById<EditText>(R.id.username_profile) }
    private val email by lazy { findViewById<EditText>(R.id.email_profile) }
    private val passwordProfile by lazy { findViewById<Button>(R.id.password_profile) }
    private val buttonLogOut by lazy { findViewById<Button>(R.id.button_log_out) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun signout(view: View) {
        firebaseAuth.signOut()
        Log.v("LOGIN", "Usuário desconectado")
    }
}