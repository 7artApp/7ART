package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.utils.view.BaseActivity
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


//class SignUpActivity : AppCompatActivity() {
class SignUpActivity : BaseActivity() {

    //    private lateinit var firebaseAuth: FirebaseAuth
    private val signUpButton by lazy { findViewById<Button>(R.id.button_sign_up_log_in) }
    private val emailSignUp by lazy { findViewById<EditText>(R.id.email_sign_up) }
    private val passwordSignUp by lazy { findViewById<EditText>(R.id.password_sign_up) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUp()

    }


    fun signUp() = signUpButton.setOnClickListener { createUser(emailSignUp, passwordSignUp) }


//     fun createUser(view: View) {
//        val email = emailSignUp.text.toString()
//        val pass = passwordSignUp.text.toString()
//
//        createUserWithEmailPass(email, pass)
//    }

//    private fun createUserWithEmailPass(email: String, pass: String) {
//        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                val user = firebaseAuth.currentUser
//                // setUserEmail(user?.email ?: "Usuário desconectado")
//            } else {
//                //   setUserEmail(task.exception?.message!!)
//            }
//        }
//    }

}