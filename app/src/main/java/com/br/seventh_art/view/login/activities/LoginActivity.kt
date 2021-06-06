package com.br.seventh_art.view.login.activities

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.GET_SIGNATURES
import android.content.pm.PackageManager.GET_SIGNING_CERTIFICATES
import android.net.Uri.encode
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.br.seventh_art.R
import java.net.URLEncoder.encode
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class LoginActivity : AppCompatActivity() {

    val signInButton by lazy { findViewById<Button>(R.id.button_sign_in_login) }
    val signUpButton by lazy { findViewById<Button>(R.id.button_sign_up_login) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signInButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            printHashKey()
        }

    }

    private fun printHashKey() = try {
        var hashKey = ""
        val info: PackageInfo = packageManager.getPackageInfo(
            packageName, if (SDK_INT >= P) GET_SIGNING_CERTIFICATES else GET_SIGNATURES
        )
        val signatures =
            if (SDK_INT >= P) info.signingInfo.apkContentsSigners else info.signatures
        signatures.forEach { signature ->
            val md: MessageDigest = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            hashKey = String(Base64.encode(md.digest(), 0))
            Log.i(javaClass.name, "printHashKey() Hash Key: $hashKey")
        }

    } catch (e: NoSuchAlgorithmException) {
        Log.e(javaClass.name, "printHashKey()", e)
    } catch (e: Exception) {
        Log.e(javaClass.name, "printHashKey()", e)
    }
}

