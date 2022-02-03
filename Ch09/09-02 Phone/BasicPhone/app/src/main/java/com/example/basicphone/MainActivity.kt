package com.example.basicphone

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CALL_PHONE),
                    PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "ใช้สิทธ์การโทรออกได้แล้ว !!!", Toast.LENGTH_LONG).show()
                cmdTel.setOnClickListener{
                    val CurrentNumber = "tel:" + tvPhoneNumber.getText()
                    val result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    if (result == PackageManager.PERMISSION_GRANTED)
                    {
                        val it = Intent(Intent.ACTION_CALL)
                        it.setData(Uri.parse(CurrentNumber))
                        startActivity(it)
                    }
                }
            }
            else
            {
                Toast.makeText(this, "คุณไม่มีสิทธิ์ใช้ฟังก์ชันการโทรออก !!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}