package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_match.*



class MatchActivity : AppCompatActivity() {

    var intComeFrom=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var activityComeFrom : String = ""
        intComeFrom = 1
        if (intent.getStringExtra(EXTRA_SPORT) != null){
            activityComeFrom = "Sport"
            intComeFrom = 8
        }
        else if (intent.getStringExtra(EXTRA_SCHOOL) != null){
            activityComeFrom = "School"
            intComeFrom = 9
        }
        else {intComeFrom = 10}
        title = "$intComeFrom"
        match_recyclerview.adapter = adapter
        match_recyclerview.layoutManager = LinearLayoutManager(this)
        match_recyclerview.setHasFixedSize(true)
    }

    //Match List
    private fun generateDummyList(size: Int): ArrayList<MatchItem> {

        val list = ArrayList<MatchItem>()
        if ( intComeFrom > 8 ){
            for (i in 0 until size) {
                val item = MatchItem("match de l'école $i", "Team $i", "Team 2","0-2")
                list += item
            }
        }
        else if ( intComeFrom == 8 ){
            for (i in 0 until size) {
                val item = MatchItem("match de sport de $i", "Team $i", "Team 2","0-2")
                list += item
            }
        }
        else {
            for (i in 0 until size) {
                val item = MatchItem("match de $i", "Team $i", "Team 2", "0-2")
                list += item
            }
        }
        return list
    }

    private val matchList = generateDummyList(50)
    private val adapter = MatchAdapter(matchList)


}
