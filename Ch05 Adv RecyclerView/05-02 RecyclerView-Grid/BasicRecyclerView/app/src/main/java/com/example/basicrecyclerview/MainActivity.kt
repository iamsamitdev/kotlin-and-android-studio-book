package com.example.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicrecyclerview.adapter.adt
import com.example.basicrecyclerview.model.rv_data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = GridLayoutManager(this, 3)

        val div = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(div)

        val rv_dataLists = mutableListOf<rv_data>()
        rv_dataLists.add(rv_data(R.drawable.word,"Word", "เอกสาร"))
        rv_dataLists.add(rv_data(R.drawable.excel, "Excel", "การคำนวณ"))
        rv_dataLists.add(rv_data(R.drawable.powerpoint,"Power Point", "นำเสนอผลงาน"))
        rv_dataLists.add(rv_data(R.drawable.access, "Access", "ข้อมูลในฐานข้อมูล"))

        val adt = adt(rv_dataLists)
        rv.adapter = adt
    }
}