package com.example.moneystream.presenters.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R

class MemberHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    var itemImage: ImageView = view.findViewById(R.id.member_item_image)
    var itemName: TextView = view.findViewById(R.id.member_item_name)
}