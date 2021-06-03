package com.br.seventh_art.view.login.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.br.seventh_art.R
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val auth = FirebaseAuth.getInstance()
        val logged = auth.currentUser != null
        val user = auth.currentUser

        val intent = if (logged) {
            Intent(this, MoviesGenresActivity::class.java)
        } else {
            Intent(this, LoginActivity::class.java)
        }

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, LoginActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}