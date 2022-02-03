package com.example.basiccamera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val PERMISSION_REQUEST_CODE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CAMERA),
                    PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "ใช้กล้องได้แล้ว !!!", Toast.LENGTH_LONG).show()
                cmdImage.setOnClickListener{
                    val result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    if (result == PackageManager.PERMISSION_GRANTED)
                    {
                        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        startActivity(it)
                    }
                }

                cmdVideo.setOnClickListener{
                    val result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    if (result == PackageManager.PERMISSION_GRANTED)
                    {
                        val it = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                        startActivity(it)
                    }
                }
            }
            else
            {
                Toast.makeText(this, "คุณไม่มีสิทธิ์ใช้กล้อง !!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}