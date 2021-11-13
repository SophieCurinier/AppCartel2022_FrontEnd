package com.example.cartel2022


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.match_item.view.*

class MatchAdapter(
    private val matchlist: List<MatchItem>
) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.match_item,
            parent, false)

        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentItem = matchlist[position]
        holder.textViewMatch.text = currentItem.match
        holder.textViewTeam1.text = currentItem.team1
        holder.textViewTeam2.text = currentItem.team2
        holder.textViewScore.text = currentItem.score
    }

    override fun getItemCount() = matchlist.size

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //All view of the list item
        val textViewMatch: TextView = itemView.match_itemTextView
        val textViewTeam1: TextView = itemView.match_itemTextViewTeam1
        val textViewTeam2: TextView = itemView.match_itemTextViewTeam2
        val textViewScore: TextView = itemView.match_itemTextViewScore
    }

}