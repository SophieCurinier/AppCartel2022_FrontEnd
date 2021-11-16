package com.example.cartel2022.model


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.R
import kotlinx.android.synthetic.main.match_item.view.*

class MatchAdapter :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //All view of the list item
        val textViewMatch: TextView = itemView.match_itemTextView
        val textViewDate: TextView = itemView.match_itemTextViewDate
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
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.match_item,
            parent, false)

        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentItem = items[position]
        holder.apply {
            textViewMatch.text = currentItem.sport
            textViewDate.text = currentItem.date
            textViewTeam1.text = currentItem.team1
            textViewTeam2.text = currentItem.team2
            if (currentItem.score_1 ==  null){
                textViewScore.text = " - "
            }
            else {textViewScore.text = (currentItem.score_1.toString() + " - " + currentItem.score_2.toString())}

        }
    }





}