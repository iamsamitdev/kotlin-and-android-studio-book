package com.example.basicmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mnuCustomer -> {
                Toast.makeText(applicationContext, "คุณเลือกเมนูลูกค้า", Toast.LENGTH_LONG).show()
                true
            }
            R.id.mnuProduct -> {
                Toast.makeText(applicationContext, "คุณเลือกเมนูสินค้า", Toast.LENGTH_LONG).show()
                true
            }
            R.id.mnuHelp -> {
                Toast.makeText(applicationContext, "คุณเลือกเมนูช่วยเหลือ", Toast.LENGTH_LONG).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}