package com.example.usinggoogleauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var google: GoogleSignInClient? = null
    private val REQUEST_SIGN_IN = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdGoogleSignIn.setOnClickListener{
            val it = google!!.signInIntent
            startActivityForResult(it, REQUEST_SIGN_IN)
        }

        val option = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        google = GoogleSignIn.getClient(this, option)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            GoogleSignIn(task)
        }
    }

    private fun GoogleSignIn(task: Task<GoogleSignInAccount>) {
        try {
            task.getResult(ApiException::class.java)
            startActivity(Intent(this@MainActivity, AuthActivity::class.java))
        } catch (e: ApiException) {
            Toast.makeText(this@MainActivity, "เกิดข้อผิดพลาดในการ Login เข้าสู่ระบบ", Toast.LENGTH_LONG).show()
        }
    }
}