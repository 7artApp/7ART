package com.br.seventh_art.view.login.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.databinding.ActivitySignUpBinding
import com.br.seventh_art.utils.view.BaseActivity
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel
import com.google.android.material.button.MaterialButton
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class SignUpActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    val button by lazy {findViewById<MaterialButton>(R.id.button_sign_up) }

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

    fun signIn(view: View) {
        val email = binding.emailSignUp.text.toString()
        val psword = binding.emailSignUp.text.toString()
        firebaseAuthWithEmailPass(email, psword)
    }

    private fun createUserWithEmailPass(email: String, psword: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                Log.v("LOGIN", user?.email ?: "Usuário desconectado")
            } else {
                Log.v("LOGIN", task.exception?.message!!)
            }
        }
    }

    fun firebaseAuthWithEmailPass(email: String, psword: String) {
        firebaseAuth.signInWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                Log.v("LOGIN", user?.email ?: "Usuário desconectado")
            } else {
                Log.v("LOGIN", task.exception?.message!!)
            }
        }
    }

    fun signOut(view: View) {
        firebaseAuth.signOut()
        Log.v("LOGIN", "Usuário desconectado")
    }
}




