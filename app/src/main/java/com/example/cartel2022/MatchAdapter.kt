package com.example.cartel2022


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.model.MatchDto
import com.example.cartel2022.model.SportDto
import kotlinx.android.synthetic.main.match_item.view.*

class MatchAdapter :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //All view of the list item
        val textViewMatch: TextView = itemView.match_itemTextView
        val textViewTeam1: TextView = itemView.match_itemTextViewTeam1
        val textViewTeam2: TextView = itemView.match_itemTextViewTeam2
        val textViewScore: TextView = itemView.match_itemTextViewScore
    }

    private val items = mutableListOf<MatchDto>()

    fun update(matchs: List<MatchDto>) {  // (4)
        items.clear()
        items.addAll(matchs)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.match_item,
            parent, false)

        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentItem = items[position]
        holder.apply {
            textViewMatch.text = currentItem.sport.toString() + " - " + currentItem.date.toString()
            textViewTeam1.text = currentItem.team1.toString()
            textViewTeam2.text = currentItem.team2.toString()
            textViewScore.text = currentItem.score1.toString() + " - " + currentItem.score2.toString()

        }
    }





}