package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {
    private val matchList = generateDummyList(500)
    private val adapter = MatchAdapter(matchList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        match_recyclerview.adapter = adapter
        match_recyclerview.layoutManager = LinearLayoutManager(this)
        match_recyclerview.setHasFixedSize(true)
    }


    //Match List
    private fun generateDummyList(size: Int): ArrayList<MatchItem> {

        val list = ArrayList<MatchItem>()

        for (i in 0 until size) {
            val item = MatchItem("match $i", "Team $i", "Team 2","0-2")
            list += item
        }
        return list
    }
}
