package com.example.cartel2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sport_item.view.*

class SportAdapter(
    private val sportList: List<SportItem>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<SportAdapter.SportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sport_item,
            parent, false)

        return SportViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val currentItem = sportList[position]

        holder.textView1.text = currentItem.text1
    }

    override fun getItemCount() = sportList.size

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val textView1: TextView = itemView.text_view_1

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}