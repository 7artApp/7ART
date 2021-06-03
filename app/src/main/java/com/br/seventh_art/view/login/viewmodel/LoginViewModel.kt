package com.br.seventh_art.view.login.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel(
) : ViewModel() {

    var email: String? = null
    var psword: String? = null
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getUser(): FirebaseUser? = firebaseAuth.currentUser ?: null

    fun createUser(
        view: View,
        email: String,
        psword: String
    ) = createUserWithEmailPass(email, psword)

    fun signIn(
        view: View,
        email: String,
        psword: String
    ) = firebaseAuthWithEmailPass(email, psword)

    fun createUserWithEmailPass(
        email: String,
        psword: String,
        view: View? = null
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = getUser()
                Log.v("LOGIN", user?.email ?: "Usuário desconectado")
                view?.let {
                    Toast.makeText(it.context, "Usuário conectado", Toast.LENGTH_LONG).show()
                }
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