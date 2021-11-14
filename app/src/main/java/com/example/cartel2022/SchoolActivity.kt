package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiServices
import com.example.cartel2022.model.SchoolService
import kotlinx.android.synthetic.main.activity_school.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchoolActivity : AppCompatActivity(),OnSchoolSelectedListener {
    private val adapter = SchoolAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_SCHOOL)

        school_recycler_view.adapter = adapter
        school_recycler_view.layoutManager = LinearLayoutManager(this)
        school_recycler_view.setHasFixedSize(true)
        school_recycler_view.adapter = adapter


        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServices().schoolsApiService.findAll().execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        adapter.update(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) { // (3)
                        Toast.makeText(
                            applicationContext,
                            "Error on windows loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }


    //When user clicks on a school button
    override fun onSchoolSelected(id: Long) {
        val intent = Intent(this, MatchActivity::class.java).putExtra(EXTRA_SCHOOL, id)
        startActivity(intent)
    }


}