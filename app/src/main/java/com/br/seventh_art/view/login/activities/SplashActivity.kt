package com.br.seventh_art.view.login.activities


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    private val SPLASH_TIME_OUT: Long = 3000 //  = 1 sec (This is the loading time of the splash screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val loginActivity = LoginActivity::class.java
        val moviesActivity = MoviesGenresActivity::class.java

        viewModel = LoginViewModel()

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, LoginActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}