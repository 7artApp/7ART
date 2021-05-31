package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.databinding.ActivitySignUpBinding
import com.br.seventh_art.utils.view.BaseActivity
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private val signUpButton by lazy { findViewById<Button>(R.id.button_sign_up_log_in) }
    private val emailSignUp by lazy { findViewById<EditText>(R.id.email_sign_up) }
    private val passwordSignUp by lazy { findViewById<EditText>(R.id.password_sign_up) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        setUserEmail(currentUser?.email ?: R.string.disconnected_user.toString())
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
                setUserEmail(user?.email ?: R.string.disconnected_user.toString())
            } else {
                setUserEmail(task.exception?.message!!)
            }
        }
    }

    fun firebaseAuthWithEmailPass(email: String, psword: String) {
        firebaseAuth.signInWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                setUserEmail(user?.email ?: R.string.disconnected_user.toString())
            } else {
                setUserEmail(task.exception?.message!!)
            }
        }
    }

    private fun setUserEmail(email: String) {
        binding.emailSignUp.apply {
            text = email
        }
    }

    fun signOut(view: View) {
        firebaseAuth.signOut()
        setUserEmail(R.string.disconnected_user.toString())
    }
}




