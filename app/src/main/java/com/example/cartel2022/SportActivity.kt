package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.SportDto
import kotlinx.android.synthetic.main.activity_sport.*

class SportActivity : AppCompatActivity(), SportAdapter.OnItemClickListener {
    //Change with length of Sport Table
    private val sportList = generateDummyList(20)
    private val adapter = SportAdapter(sportList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)

        sport_recycler_view.adapter = adapter
        sport_recycler_view.layoutManager = LinearLayoutManager(this)
        sport_recycler_view.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_SPORT)
    }


        //When user clicks on a sport button
    override fun onItemClick(position: Int) {
            val clickedItem = sportList[position]
            adapter.notifyItemChanged(position)
            val intent = Intent(this, MatchActivity::class.java).apply {
                putExtra(EXTRA_SPORT, clickedItem.sportName)
            }
            startActivity(intent)
        }

    //Only for test while Data Base is not ready
    private fun generateDummyList(size: Int): ArrayList<SportDto> {
        val list = ArrayList<SportDto>()
        for (i in 0 until size) {
            val item = SportDto("Sport $i")
            list += item
        }
        return list
    }
}

