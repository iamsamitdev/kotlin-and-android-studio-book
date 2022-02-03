package com.example.recyclerviewglide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewglide.adapter.adt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val arrName = ArrayList<String>()
    private val arrUrl = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrName.add("ต้นไม้ 1")
        arrUrl.add("url")

        arrName.add("ต้นไม้ 2")
        arrUrl.add("url")

        arrName.add("ต้นไม้ 3")
        arrUrl.add("url")

        val adapter = adt(this, arrName, arrUrl)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}