package com.example.basicsharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val PreName = "db"
    lateinit var sharedPre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPre = this.getSharedPreferences(PreName, Context.MODE_PRIVATE)
        readData("FullName")

        cmdAdd.setOnClickListener{
            addData("FullName", edtData.getText().toString().trim())
            readData("FullName")
            edtData.setText("")
        }

        cmdRead.setOnClickListener{
            tvOutput.setText(readData("FullName").toString().trim())
            edtData.setText("")
        }

        cmdClear.setOnClickListener{
            clearData()
            readData("FullName")
            edtData.setText("")
        }

        cmdRemove.setOnClickListener{
            removeData("FullName")
            readData("FullName")
            edtData.setText("")
        }
    }

    fun addData(KEY_NAME: String, data: String) {
        val editor: SharedPreferences.Editor = sharedPre.edit()
        editor.putString(KEY_NAME, data)
        editor.commit()
    }

    fun readData(KEY_NAME: String) {
        val data = sharedPre.getString(KEY_NAME, "ไม่มีข้อมูลแล้ว!!!")
        tvOutput.setText(data)
    }

    fun clearData() {
        val editor: SharedPreferences.Editor = sharedPre.edit()
        editor.clear()
        editor.commit()
    }

    fun removeData(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = sharedPre.edit()
        editor.remove(KEY_NAME)
        editor.commit()
    }
}