package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.view.login.helper.Utils
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class SignInActivity : AppCompatActivity(), Utils {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    private val googleButton by lazy {findViewById<ImageView>(R.id.google_sign_up)}
    private val buttonLogin by lazy { findViewById<Button>(R.id.button_log_in) }
    private val emailSignIn by lazy { findViewById<EditText>(R.id.username_sign_in) }
    private val passwordSignIn by lazy { findViewById<EditText>(R.id.password_sign_in) }
    private val buttonBack by lazy { findViewById<ImageView>(R.id.button_back) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initView()

        googleSignIn()

        initClick()
    }

    override fun onStart() {
        super.onStart()

        val currentUser = firebaseAuth.currentUser
        setUserEmail(currentUser?.email?: "Usuário desconhecido")
    }

    private fun setUserEmail(email: String) {
//        <TEXVIEW_NOME_USUARIO>.text = email
    }

    private fun initView() = setContentView(R.layout.activity_sign_in)

    private fun googleSignIn() {

        firebaseAuth = FirebaseAuth.getInstance()

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .requestId()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions)

        googleButton.setOnClickListener{signin(it)}
    }

    private fun signin(view: View){

        val sigInIntent = googleSignInClient.signInIntent
        startActivityForResult(sigInIntent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 200) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("GoogleSign", "firebaseAuthWithGoogle:" + account.idToken)
                firebaseAuthWithGoogle(account.idToken!!)
                goToMovies()
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("GoogleSign", "Google sign in failed", e)
            }catch (e: Exception) {
                setUserEmail("Erro ao efetuar login")
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("GoogleSign", "signInWithCredential:success")
                    val user = firebaseAuth.currentUser
                    setUserEmail(user?.email ?: "Usuário desconectado")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("GoogleSign", "signInWithCredential:failure", task.exception)
                    setUserEmail("Erro ao efetuar login")
                }
            }
    }

    private fun goToMovies(){

        val intent = Intent(this, MoviesGenresActivity::class.java)
        startActivity(intent)
    }

    private fun initClick() {
        buttonLogin.setOnClickListener() {
            if (validatePassword(passwordSignIn) && validateName(emailSignIn)) {
                val intent = Intent(this, MoviesGenresActivity::class.java)
                startActivity(intent)
            }

            buttonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}