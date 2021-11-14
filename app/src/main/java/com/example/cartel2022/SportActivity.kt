package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.SchoolService
import com.example.cartel2022.model.SportDto
import com.example.cartel2022.model.SportService
import kotlinx.android.synthetic.main.activity_sport.*

class SportActivity : AppCompatActivity(), OnSchoolSelectedListener {
    //Change with length of Sport Table

    private val adapter = SportAdapter(this)

    val sportService = SportService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_SPORT)

        sport_recycler_view.layoutManager = LinearLayoutManager(this)
        sport_recycler_view.setHasFixedSize(true)
        sport_recycler_view.adapter = adapter

        adapter.update(sportService.findAll())
    }


    override fun onSchoolSelected(id: Long) {
        val intent = Intent(this, MatchActivity::class.java).putExtra(EXTRA_SPORT, id)
        startActivity(intent)
    }
}

