package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_sport.*
import kotlin.random.Random

class SportActivity : AppCompatActivity(), SportAdapter.OnItemClickListener {
    //Change with length of Sport Table
    private val sportList = generateDummyList(15)
    private val adapter = SportAdapter(sportList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)

        sport_recycler_view.adapter = adapter
        sport_recycler_view.layoutManager = LinearLayoutManager(this)
        sport_recycler_view.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MESSAGE)
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(8)

        val newItem = SportItem(
            "New item at position $index"
        )

        sportList.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

        //When user clicks on a sport button
        override fun onItemClick(position: Int) {
            Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
            val clickedItem = sportList[position]
            clickedItem.text1 = "Clicked"
            adapter.notifyItemChanged(position)
            val intent = Intent(this, MatchActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, clickedItem.text1)
            }
            startActivity(intent)
        }

    //Only for test while Data Base is not ready
    private fun generateDummyList(size: Int): ArrayList<SportItem> {
        val list = ArrayList<SportItem>()
        for (i in 0 until size) {
            val item = SportItem("Item $i")
            list += item
        }
        return list
    }
}

