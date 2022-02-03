package com.example.basicalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdShow.setOnClickListener{
            val b = AlertDialog.Builder(this)
            b.setTitle("ผลการทำงาน")
            b.setMessage("แสดงข้อมูลสมบูรณ์แล้ว")
            b.setIcon(android.R.drawable.ic_dialog_alert)

            b.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"คุณคลิกที่ปุ่ม Yes",Toast.LENGTH_LONG).show()
            }

            b.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext,"คุณคลิกที่ปุ่ม No",Toast.LENGTH_LONG).show()
            }

            b.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"คุณคลิกที่ปุ่ม Cancel",Toast.LENGTH_LONG).show()
            }

            val alt: AlertDialog = b.create()
            alt.show()
        }
    }
}