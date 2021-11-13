package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_school.*

class SchoolActivity : AppCompatActivity(),SportAdapter.OnItemClickListener {
    //Change with length of Sport Table
    private val schoolList = generateDummyList(20)
    private val adapter = SportAdapter(schoolList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MATCHSCHOOL)

        school_recycler_view.adapter = adapter
        school_recycler_view.layoutManager = LinearLayoutManager(this)
        school_recycler_view.setHasFixedSize(true)
    }


    //When user clicks on a school button
    override fun onItemClick(position: Int) {
        val clickedItem = schoolList[position]
        adapter.notifyItemChanged(position)
        val intent = Intent(this, MatchActivity::class.java).apply {
            putExtra(EXTRA_SCHOOL, clickedItem.sportName)
        }
        startActivity(intent)
    }

    //Only for test while Data Base is not ready
    private fun generateDummyList(size: Int): ArrayList<SportItem> {
        val list = ArrayList<SportItem>()
        for (i in 0 until size) {
            val item = SportItem("School $i")
            list += item
        }
        return list
    }
}