package com.example.cartel2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.model.SchoolDto

class RankingAdapter() :
    RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {

    inner class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewSchool: TextView = itemView.findViewById(R.id.text_view_school)
        val textViewScore : TextView = itemView.findViewById(R.id.text_view_score)
        val textViewRank : TextView = itemView.findViewById(R.id.text_view_rank)
    }

    private val items = mutableListOf<SchoolDto>()

    fun update(schools: List<SchoolDto>) {  // (4)
        items.clear()
        items.addAll(schools)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ranking_item,
            parent, false
        )

        return RankingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val currentItem = items[position]
        holder.apply {
            holder.textViewSchool.text = currentItem.name
            holder.textViewRank.text = (position+1).toString()
            holder.textViewScore.text = "0" // (1)
        }
    }

}