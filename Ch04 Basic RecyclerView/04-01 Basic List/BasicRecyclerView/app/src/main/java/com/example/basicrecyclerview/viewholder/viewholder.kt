package com.example.basicrecyclerview.viewholder

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R
import kotlinx.android.synthetic.main.rv_row.view.*

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView = itemView.findViewById<TextView>(R.id.textView)

    init {
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, textView.text, Toast.LENGTH_LONG).show()
        }
    }
}

