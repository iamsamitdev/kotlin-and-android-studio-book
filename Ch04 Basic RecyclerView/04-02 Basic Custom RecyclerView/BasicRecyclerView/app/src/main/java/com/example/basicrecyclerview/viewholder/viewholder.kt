package com.example.basicrecyclerview.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R
import kotlinx.android.synthetic.main.rv_row.view.*

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgFileIcon = itemView.findViewById<ImageView>(R.id.imgFileIcon)
    var tvFileType = itemView.findViewById<TextView>(R.id.tvFileType)
    var tvFileDescription = itemView.findViewById<TextView>(R.id.tvFileDescription)

    init {
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, tvFileType.text, Toast.LENGTH_LONG).show()
        }
    }
}

