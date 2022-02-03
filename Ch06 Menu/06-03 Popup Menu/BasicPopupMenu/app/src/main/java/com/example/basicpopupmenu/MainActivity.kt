package com.example.basicpopupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdShow.setOnClickListener {
            val mnuPopup: PopupMenu = PopupMenu(this, cmdShow)
            mnuPopup.menuInflater.inflate(R.menu.menu_popup, mnuPopup.menu)
            mnuPopup.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.mnuHelp ->
                        Toast.makeText(this, "คุณเลือกเมนูช่วยเหลือ", Toast.LENGTH_LONG).show()
                    R.id.mnuWebboard ->
                        Toast.makeText(this, "คุณเลือกเมนูเว็บบอร์ด", Toast.LENGTH_LONG).show()
                }
                true
            }
            mnuPopup.show()
        }
    }
}