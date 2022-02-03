package com.example.usingjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UseButton()
        }
    }

    @Composable
    fun UseButton() {
        val context = LocalContext.current

        Button(onClick = {
            Toast.makeText(context, "คุณคลิกปุ่มกด Button", Toast.LENGTH_LONG).show()
        })
        {
            Text("คลิกที่นี่")
        }
    }
}