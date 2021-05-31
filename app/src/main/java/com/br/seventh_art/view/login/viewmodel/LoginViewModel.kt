package com.br.seventh_art.view.login.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginViewModel(
) : ViewModel() {

    var currentUser: FirebaseUser? = null
    var email: String? = null
    var psword: String? = null

    init {
        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    }
}