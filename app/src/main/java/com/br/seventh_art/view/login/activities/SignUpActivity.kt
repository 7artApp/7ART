package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.databinding.ActivitySignUpBinding
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel


class SignUpActivity : AppCompatActivity() {

    lateinit var viewmodel: LoginViewModel
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewmodel = LoginViewModel()
    }

    override fun onResume() {
        super.onResume()

        binding.apply {

            buttonSignUp.setOnClickListener { view ->
                viewmodel.createUser(
                    view.rootView,
                    emailSignUp.text.toString(),
                    passwordSignUp.text.toString()
                )
                viewmodel.signIn(
                    view.rootView,
                    emailSignUp.text.toString(),
                    passwordSignUp.text.toString()
                )
                viewmodel.getUser()?.let {
                    startActivity(Intent(this@SignUpActivity, MoviesGenresActivity::class.java))
                    this@SignUpActivity.finish()
                }
            }
            toolbarSignUp.setNavigationOnClickListener { onBackPressed() }
        }
    }
}





