package com.example.moneystream.presenters.views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R

class EventAdapter(private val context: Context?,
                   private val itemClickListener: EventHolder.ItemClickListener,
                   private val itemList: List<EventItem>)
    :RecyclerView.Adapter<EventHolder>() {

    private var myRecyclerView : RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        myRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val layout = LayoutInflater.from(parent.context)
        val view = layout.inflate(R.layout.recycler_event_item, parent, false)
        view.setOnClickListener{
            myRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }
        return EventHolder(view)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.let {
            var item = itemList[position]
            it.itemImage.setImageResource(item.icon)
            it.itemTitle.text = item.title
            it.itemDetail.text = item.detail
        }
    }

    override fun getItemCount(): Int = itemList.size
}