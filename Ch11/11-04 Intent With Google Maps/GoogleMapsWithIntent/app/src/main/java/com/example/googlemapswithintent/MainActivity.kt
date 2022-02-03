package com.example.googlemapswithintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdSearch.setOnClickListener{
            var currentPlace = edtPlace.text.toString().trim()
            if (currentPlace.isEmpty()) {
                Toast.makeText(this, "กรุณาระบุสถานที่ !!!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            currentPlace = currentPlace.replace(' ', '+');

            val geoUri = "geo:0,0?q=$currentPlace&z=$10"
            val it = Intent(Intent.ACTION_VIEW)
            it.data = Uri.parse(geoUri)
            it.setPackage("com.google.android.apps.maps")
            startActivity(it)
        }
    }
}