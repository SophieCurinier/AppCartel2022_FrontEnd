package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FieldClassification
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiServices
import com.example.cartel2022.model.SchoolService
import com.example.cartel2022.model.SportDto
import kotlinx.android.synthetic.main.activity_school.*

class SchoolActivity : AppCompatActivity(),OnSchoolSelectedListener {
    //Change with length of Sport Table
    private val adapter = SchoolAdapter(this)
    val schoolService = SchoolService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MATCHSCHOOL)

        school_recycler_view.adapter = adapter
        school_recycler_view.layoutManager = LinearLayoutManager(this)
        school_recycler_view.setHasFixedSize(true)
        school_recycler_view.adapter = adapter

        adapter.update(schoolService.findAll())
        //runCatching { ApiServices().schoolsApiService.findAll().execute() } // (1)
        //    .onSuccess { adapter.update(it.body() ?: emptyList()) }  // (2)
        //    .onFailure {
        //        Toast.makeText(this, "Error on windows loading $it", Toast.LENGTH_LONG).show()  // (3)
        }


    //When user clicks on a school button
    override fun onSchoolSelected(id: Long) {
        val intent = Intent(this, MatchActivity::class.java).putExtra(EXTRA_SCHOOL, id)
        startActivity(intent)
    }


}