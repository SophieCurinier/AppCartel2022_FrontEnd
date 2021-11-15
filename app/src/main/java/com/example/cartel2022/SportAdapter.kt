package com.example.cartel2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.model.SportDto

class SportAdapter(val listener: OnItemSelectedListener) : RecyclerView.Adapter<SportAdapter.SportViewHolder>() {

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.text_view_1)
    }

    private val items = mutableListOf<SportDto>()

    fun update(windows: List<SportDto>) {  // (4)
        items.clear()
        items.addAll(windows)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sport_item,
            parent, false)

        return SportViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val currentItem = items[position]
        holder.apply {
            name.text = currentItem.name
            itemView.setOnClickListener { listener.onItemSelected(currentItem.id) }
        }
    }

    override fun onViewRecycled(holder: SportViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }
    }
}