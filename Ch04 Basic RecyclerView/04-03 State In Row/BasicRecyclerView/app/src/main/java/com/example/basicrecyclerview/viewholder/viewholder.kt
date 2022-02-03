package com.example.basicrecyclerview.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R
import kotlinx.android.synthetic.main.rv_row.view.*

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgFileIcon = itemView.findViewById<ImageView>(R.id.imgFileIcon)
    var tvFileType = itemView.findViewById<TextView>(R.id.tvFileType)
    var tvFileDescription = itemView.findViewById<TextView>(R.id.tvFileDescription)
    var swStatus = itemView.findViewById<Switch>(R.id.swStatus)

    init {
        itemView.setOnClickListener {
            val userSelected = if (swStatus.isChecked) "เลือก" else "ไม่เลือก"
            Toast.makeText(itemView.context, "${tvFileType.text}-$userSelected", Toast.LENGTH_LONG).show()
        }
    }
}

