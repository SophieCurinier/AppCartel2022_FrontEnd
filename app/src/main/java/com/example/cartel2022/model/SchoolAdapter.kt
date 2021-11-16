package com.example.cartel2022.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.OnItemSelectedListener
import com.example.cartel2022.R

class SchoolAdapter(
    private val listener: OnItemSelectedListener
) :
    RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {

    inner class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
    }

    private val items = mutableListOf<SchoolDto>()

    fun update(schools: List<SchoolDto>) {  // (4)
        items.clear()
        items.addAll(schools)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.sport_item,
            parent, false
        )

        return SchoolViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val currentItem = items[position]
        holder.apply {
            holder.textView1.text = currentItem.name
            itemView.setOnClickListener { listener.onItemSelected(currentItem.id, currentItem.name) } // (1)
        }
    }

    override fun onViewRecycled(holder: SchoolViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }
    }

}