package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.seventh_art.R
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.ktx.Firebase


class SignInActivity : AppCompatActivity() {
//class SignInActivity : BaseActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        firebaseAuth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()

        googleSignIn()

        signInButton()


    }


//    override fun onStart() {
//        super.onStart()
//
//        val currentUser = firebaseInstance.currentUser
//    }

    private fun initView() = setContentView(R.layout.activity_sign_in)

    private fun googleSignIn() {

        firebaseAuth = FirebaseAuth.getInstance()

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .requestId()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        googleButton.setOnClickListener { signInGoogle(it) }
    }

    private fun facebookSignIn() {
        loginManager.logInWithReadPermissions(this, arrayListOf("email", "public_profile"))
        loginManager.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.d("facebook", "facebook:onSuccess:$loginResult")
                firebaseAuthWithFacebook(loginResult.accessToken)
            }

            override fun onCancel() {
                Log.d("facebook", "facebook:onCancel")
            }

            override fun onError(error: FacebookException) {
                Log.d("facebook", "facebook:onError", error)
            }
        })
    }

    private fun firebaseAuthWithFacebook(token: AccessToken) {
        Log.d("facebook", "handleFacebookAccessToken:$token")
        val credential = FacebookAuthProvider.getCredential(token.token)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("facebook", "signInWithCredential:success")
                    val name = firebaseAuth.currentUser?.displayName
                    goToMovies()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("facebook", "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun signInGoogle(view: View) {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 200)
    }

    fun signInFace(view: View) {
        facebookSignIn()
        tryLoginFacebook = true
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
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("GoogleSign", "Google sign in failed", e)
            } catch (e: Exception) {
            }
        }
        if (tryLoginFacebook) {
            callbackManager.onActivityResult(requestCode, resultCode, data)
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
                    goToMovies()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("GoogleSign", "signInWithCredential:failure", task.exception)
                }
            }
    }


//    fun signin(view: View) {
//        if (firebaseInstance.currentUser != null) {
//            val bundle = Bundle().apply {
//                putString("email", firebaseInstance.currentUser!!.email)
//            }
//            firebaseAnalytics.logEvent("login", bundle)
//            startActivity(Intent(this, MoviesGenresActivity::class.java))
//        } else {
//            val email = emailSignIn.text.toString()
//            val pass = passwordSignIn.text.toString()
//
//            firebaseAuthWithEmailPass(email, pass)
//        }
//    }

    private fun firebaseAuthWithEmailPass(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                startActivity(Intent(this, MoviesGenresActivity::class.java))
            } else {
                //  setUserEmail(task.exception?.message!!)
            }
        }
    }

    private fun goToMovies() {
        val intent = Intent(this, MoviesGenresActivity::class.java)
        startActivity(intent)
    }

    fun signInButton() = buttonLogin.setOnClickListener {

//        signin(MoviesGenresActivity::class, emailSignIn, passwordSignIn)
    }
}