package com.br.seventh_art.view.profile

import android.content.Intent
import android.os.Bundle
import android.system.Os.close
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.activities.SignInActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private val imageProfile by lazy { findViewById<ImageView>(R.id.image_profile) }
    private val userEmail by lazy { findViewById<EditText>(R.id.user_email) }
    private val buttonSignOut by lazy { findViewById<Button>(R.id.button_sign_out) }
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.toolbar_profile) }

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        toolbar.setNavigationOnClickListener {

            onBackPressed()
            finish()}

        firebaseAuth = FirebaseAuth.getInstance()

        buttonSignOut.setOnClickListener {
            signOut(it.rootView)
            startActivity(Intent(it.context, SignInActivity::class.java))
            finish()
            finish()
        }
    }

    fun signOut(view: View) {
        firebaseAuth.signOut()
        Log.v("LOGIN", "Usuário desconectado")
    }
}