package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.databinding.ActivitySignInBinding
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.login.viewmodel.LoginViewModel
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val firebaseAnalytics = Firebase.analytics
    private lateinit var callbackManager: CallbackManager
    private var tryLoginFacebook = false
    private val loginManager = LoginManager.getInstance()
    private val googleButton by lazy { findViewById<ImageView>(R.id.google_sign_in) }
    private val buttonLogin by lazy { findViewById<Button>(R.id.button_log_in) }
    private val emailSignIn by lazy { findViewById<EditText>(R.id.username_sign_in) }
    private val passwordSignIn by lazy { findViewById<EditText>(R.id.password_sign_in) }
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = LoginViewModel()

    }

    override fun onResume() {
        super.onResume()

        binding.apply {
            buttonLogIn.setOnClickListener {
                viewModel.firebaseAuthWithEmailPass(
                    emailSignIn.text.toString(),
                    passwordSignIn.text.toString()
                )
                viewModel.getUser()?.let {
                    startActivity(Intent(this@SignInActivity, MoviesGenresActivity::class.java))
                    this@SignInActivity.finish()
                }
            }
        }
    }
}
