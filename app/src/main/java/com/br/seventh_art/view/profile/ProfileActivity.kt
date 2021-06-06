package com.br.seventh_art.view.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.br.seventh_art.R
import com.br.seventh_art.databinding.ActivityProfileBinding
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.activities.LoginActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        binding.buttonLogOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            Log.v("LOGIN", "Usuário desconectado")
        }

        binding.emailProfile.text = firebaseAuth.currentUser.email

        binding.usernameProfile.text = firebaseAuth.currentUser.displayName

        binding.toolbarSignUp.setNavigationOnClickListener { onBackPressed() }
    }
}