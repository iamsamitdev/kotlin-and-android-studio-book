package com.example.usinggoogleauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    var google: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val option = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        google = GoogleSignIn.getClient(this, option)
        val user = GoogleSignIn.getLastSignedInAccount(this@AuthActivity)
        if (user != null) {
            val displayname: String? = user.getDisplayName()
            val email: String? = user.getEmail()

            tvDisplayName.setText(displayname)
            tvEmail.setText(email)
        }

        cmdGoogleSignOut.setOnClickListener{
            google!!.signOut()
                .addOnCompleteListener(this, OnCompleteListener<Void?> {
                    Toast.makeText(this@AuthActivity,"ออกจากระบบ", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@AuthActivity, MainActivity::class.java))
                    finish()
                })
        }
    }
}