package com.example.moneystream.presenters.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R

class EventHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    var itemImage: ImageView = view.findViewById(R.id.item_image)
    var itemTitle: TextView = view.findViewById(R.id.item_title)
    var itemDetail: TextView = view.findViewById(R.id.item_detail)
}