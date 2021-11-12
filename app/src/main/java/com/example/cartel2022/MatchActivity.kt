package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MatchActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // title = "Football"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        title = message
    }
    private fun prepareItems() {
        itemsList.add("Match 1")
        itemsList.add("Match 2")
        itemsList.add("Rugby M")
        itemsList.add("Rugby F")
        itemsList.add("Handball M")
        itemsList.add("Handball F")
        itemsList.add("Volley M")
        itemsList.add("Volley F")
        itemsList.add("Natation")
        itemsList.add("Boxe")
        itemsList.add("VTT")
        itemsList.add("DJ Contest")
        itemsList.add("Pompom")
        customAdapter.notifyDataSetChanged()
    }
}