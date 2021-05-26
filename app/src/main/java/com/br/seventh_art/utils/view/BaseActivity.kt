package com.br.seventh_art.utils.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

open class BaseActivity : AppCompatActivity() {
    //    private lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var firebaseInstance: FirebaseAuth

    //    private val firebasePush = Firebase.messaging
    val firebaseAnalytics = Firebase.analytics

//    private val emailTv by lazy { findViewById<TextView>(R.id.emailTv) }
//    private val emailEt by lazy { findViewById<EditText>(R.id.email) }
//    private val passEt by lazy { findViewById<EditText>(R.id.pass) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseInstance = Firebase.auth


//        firebaseDatabase = Firebase.database

//        firebasePush.token.addOnCompleteListener {
//            if (it.isSuccessful) {
//                Log.d("FirebasePushToken", it.result)
//            }
//        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseInstance.currentUser
//        setUserEmail(currentUser?.email ?: "Usuário desconectado")
    }

    open fun createUser(email: EditText, psword: EditText) {
        val email = email.text.toString()
        val pass = psword.text.toString()

        createUserWithEmailPass(email, pass)
    }

    open fun signin(context: Context, email: EditText, psword: EditText) {
        if (firebaseInstance.currentUser != null) {
            val bundle = Bundle().apply {
                putString("email", firebaseInstance.currentUser!!.email)
            }
            firebaseAnalytics.logEvent("login", bundle)
            startActivity(Intent(this, context::class.java))
//            startActivity(Intent(this, context::class.java))
        } else {
            val email = email.text.toString()
            val pass = psword.text.toString()

            firebaseAuthWithEmailPass(email, pass, context)
        }
    }

    fun createUserWithEmailPass(email: String, pass: String) {
        firebaseInstance.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseInstance.currentUser
//                setUserEmail(user?.email ?: "Usuário desconectado")
            } else {
//                setUserEmail(task.exception?.message!!)
            }
        }
    }

    fun firebaseAuthWithEmailPass(email: String, pass: String, context: Context) {
        firebaseInstance.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseInstance.currentUser
//                setUserEmail(user?.email ?: "Usuário desconectado")
                startActivity(Intent(this, context::class.java))
            } else {
//                setUserEmail(task.exception?.message!!)
            }
        }
    }

    fun back(view: View) {
        onBackPressed()
    }

//    fun setUserEmail(email: String, editText: EditText) {
//        emailTv.text = email
//    }

    fun signout(view: View) {
//        throw RuntimeException("Test Crash")

        firebaseInstance.signOut()
//        setUserEmail("Usuário desconectado")
    }

//    fun addUser(view: View) {
//        firebaseAuth.currentUser?.let { user ->
////            val subject = Subject("Firebase Database")
//            val userDb = User(
//                user.email ?: "",
//                "Jose Santos",
//                subject,
//                FavoriteMovie(listOf("Interestelar", "Run"))
//            )
//
//            val reference = firebaseDatabase.getReference("users")
//
//            reference
//                .child(user.uid)
//                .setValue(userDb)
//            reference.child(user.uid).child("favorite_movies")
//                .setValue(FavoriteMovie(listOf("Interestelar", "Run")))
//
//            reference.child(user.uid).addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    handleUser(snapshot)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    error
//                }
//            })
//        }
//    }
//
//    fun handleUser(snapshot: DataSnapshot) {
//        val user = snapshot.getValue(User::class.java)
//        user.toString()
//    }
//
//    fun handleUserData(snapshot: DataSnapshot) {
//        firebaseAuth.currentUser?.let {
//            val uid = it.uid
//            val data: HashMap<String, String> = snapshot.value as HashMap<String, String>
//            val user: HashMap<String, String> = data[uid] as HashMap<String, String>
//            val email = user["email"] ?: ""
//            val name = user["name"] ?: ""
//            val subject = (user["subject"] as HashMap<String, String>)["type"] ?: ""
//
//            val userMapped =
//                User(email = email, name = name, subject = Subject((subject)), movies = null)
//
//            Toast.makeText(this, userMapped.toString(), Toast.LENGTH_LONG).show()
//        }
//    }

}