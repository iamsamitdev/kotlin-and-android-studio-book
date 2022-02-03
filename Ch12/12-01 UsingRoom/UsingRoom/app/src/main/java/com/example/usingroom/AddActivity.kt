package com.example.usingroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usingroom.db.ThaivbDB
import com.example.usingroom.model.Product
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var db: ThaivbDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ThaivbDB.getDatabase(this)?.let {
            db = it
        }

        cmdAdd.setOnClickListener{
            if (edtProductName.text.isNotEmpty() && edtProductPrice.text.isNotEmpty()) {
                val p = Product(null, edtProductName.text.toString(), edtProductPrice.text.toString().toInt())

                GlobalScope.launch {
                    db.productDAO().add(p)
                    runOnUiThread {
                        Toast.makeText(this@AddActivity, "บันทึกข้อมูลสินค้าใหม่แล้ว", Toast.LENGTH_LONG).show()
                        this@AddActivity.finish()
                    }
                }
            } else {
                Toast.makeText(this@AddActivity, "กรุณป้อนข้อมูลสินค้าให้ครบก่อนครับ", Toast.LENGTH_LONG).show()
            }
        }
    }
}