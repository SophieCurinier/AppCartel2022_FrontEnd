package com.example.cartel2022.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.OnUrlSelectedListener
import com.example.cartel2022.R

class PartnerAdapter(val listener: OnUrlSelectedListener): RecyclerView.Adapter<PartnerAdapter.PartnerViewHolder>() {

    inner class PartnerViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val image: ImageView = view.findViewById(R.id.partner_image)
    }

    private val items = mutableListOf<PartnerDto>() // (3)

    fun update(partners: List<PartnerDto>) {  // (4)
        items.clear()
        items.addAll(partners)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnerViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.partner_item, parent, false)
        return PartnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PartnerViewHolder, position: Int) {  // (7)
        val items = items[position]
        holder.apply {
            image.setImageResource(items.img)
            itemView.setOnClickListener { listener.onUrlSelected(items.txt) }
        }
    }

    override fun onViewRecycled(holder: PartnerViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }
    }
}