package com.br.seventh_art.view.login.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginViewModel(
) : ViewModel() {

    var currentUser: FirebaseUser? = null
    var email: String? = null
    var psword: String? = null
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getCurrentUser() {
        val currentUser = firebaseAuth.currentUser
        setUserEmail(currentUser?.email ?: "Usuário desconectado")
    }

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
        psword: String
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                setUserEmail(user?.email ?: "Usuário desconectado")
            } else {
                setUserEmail(task.exception?.message!!)
            }
        }
    }

    fun firebaseAuthWithEmailPass(
        email: String,
        psword: String
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, psword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                setUserEmail(user?.email ?: "Usuário desconectado")
            } else {
                setUserEmail(task.exception?.message!!)
            }
        }
    }

    fun setUserEmail(email: String) {}

    fun signOut(view: View) {
        firebaseAuth.signOut()
        setUserEmail("Usuário desconectado")
    }
}