package com.example.firstapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdShow.setOnClickListener{ view->
            tvOutput.text = "สวัสดี Android-Kotlin"
            Toast.makeText(this, "สวัสดี Android-Kotlin", Toast.LENGTH_LONG).show()
        }
    }
}