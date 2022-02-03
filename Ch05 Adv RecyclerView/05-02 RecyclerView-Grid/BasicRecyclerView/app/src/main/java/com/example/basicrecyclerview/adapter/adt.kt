package com.example.basicrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R
import com.example.basicrecyclerview.model.rv_data
import com.example.basicrecyclerview.viewholder.viewholder

class adt(val data: List<rv_data>) : RecyclerView.Adapter<viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val rv_row = LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        val holder = viewholder(rv_row)
        return holder
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.apply {
            imgFileIcon.setImageResource(data[position].fileicon)
            tvFileType.text = data[position].filetype
            tvFileDescription.text = data[position].filedescription
        }
    }
}

