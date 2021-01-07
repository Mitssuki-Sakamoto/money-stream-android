package com.example.moneystream.presenters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R

class RecycleAdapter(private val context: Context?,
                     private val itemClickListener: AdapterView.OnItemClickListener: RecycleHolder.ItemClickListener,
                     private val itemList: List<ListItem>)
    :RecyclerView.Adapter<RecycleHolder>() {

    private var myRecyclerView : RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        myRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleHolder {
        val layout = LayoutInflater.from(parent.context)
        val view = layout.inflate(R.layout.recycler_item, parent, false)
        view.setOnClickListener{
            myRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }
        return RecycleHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.let {
            var item = itemList[position]
            it.itemImage.setImageResource(item.icon)
            it.itemTitle.text = item.title
            it.itemDetail.text = item.detail
        }
    }

    override fun getItemCount(): Int = itemList.size
}