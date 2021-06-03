package com.br.seventh_art.view.login.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.databinding.ActivitySignUpBinding
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        //VERIFICA SE EXISTE UM CURRENT USER (SPLASH SCREEN)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.apply {
            buttonSignUp.setOnClickListener {
                createUser(this.root)
            }
        }
    }

    fun createUser(view: View) {
        val email = binding.emailSignUp.text.toString()
        val psword = binding.emailSignUp.text.toString()

        createUserWithEmailPass(email, psword)
    }

    private fun createUserWithEmailPass(email: String, psword: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                startActivity(Intent(this, MoviesGenresActivity::class.java))
            } else {
                Log.v("LOGIN", task.exception?.message!!)
            }
        }
    }
}




