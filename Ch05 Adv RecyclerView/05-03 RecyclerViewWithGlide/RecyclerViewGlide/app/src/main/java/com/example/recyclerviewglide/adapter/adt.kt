package com.example.recyclerviewglide.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewglide.DetailActivity
import com.example.recyclerviewglide.R

class adt(_context: Context, _arrName: ArrayList<String>, _arrUrl: ArrayList<String>) : RecyclerView.Adapter<adt.ViewHolder>() {
    private var arrName = ArrayList<String>()
    private var arrUrl = ArrayList<String>()
    private val Context: Context

    init {
        arrName = _arrName
        arrUrl = _arrUrl
        Context = _context
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainLayout: LinearLayout
        var img: ImageView
        var tvName: TextView

        init {
            mainLayout = itemView.findViewById(R.id.mainlayout)
            img = itemView.findViewById(R.id.img)
            tvName = itemView.findViewById(R.id.tvName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(Context)
            .asBitmap()
            .load(arrUrl[position])
            .into(holder.img)
        holder.tvName.text = arrName[position]

        holder.mainLayout.setOnClickListener {
            Toast.makeText(Context, arrName[position], Toast.LENGTH_SHORT).show()

            val it = Intent(Context, DetailActivity::class.java)
            it.putExtra("image_name", arrName[position])
            it.putExtra("image_url", arrUrl[position])
            Context.startActivity(it)
        }
    }

    override fun getItemCount(): Int {
        return arrName.size
    }
}