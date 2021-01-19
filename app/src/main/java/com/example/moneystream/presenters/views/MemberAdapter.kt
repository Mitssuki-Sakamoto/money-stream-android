package com.example.moneystream.presenters.views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R

class MemberAdapter(private val context: Context?,
                    private val itemClickListener: MemberHolder.ItemClickListener,
                    private val itemList: List<MemberItem>)
    :RecyclerView.Adapter<MemberHolder>() {

        private var myRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        myRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberHolder {
        val layout = LayoutInflater.from(parent.context)
        val view = layout.inflate(R.layout.recycler_event_item, parent, false)
        view.setOnClickListener{
            myRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }
        return MemberHolder(view)
    }

    override fun onBindViewHolder(holder: MemberHolder, position: Int) {
        holder.let {
            var item = itemList[position]
            it.itemImage.setImageResource(item.icon)
            it.itemName.text = item.name
        }
    }

    override fun getItemCount(): Int = itemList.size
}
