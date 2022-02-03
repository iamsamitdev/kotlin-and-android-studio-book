package com.example.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicrecyclerview.adapter.adt
import com.example.basicrecyclerview.model.rv_data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = LinearLayoutManager(this)

        val div = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(div)

        val rv_dataLists = mutableListOf<rv_data>()
        rv_dataLists.add(rv_data("การสร้างเอกสารด้วย Word"))
        rv_dataLists.add(rv_data("พื้นฐานการใช้งานฟังก์ชันใน Excel"))
        rv_dataLists.add(rv_data("การนำเสนอข้อมูลในระดับมืออาชีพด้วย Power Point"))
        rv_dataLists.add(rv_data("การจัดเก็บข้อมูลในฐานข้อมูล Access"))

        val adt = adt(rv_dataLists)
        rv.adapter = adt
    }
}