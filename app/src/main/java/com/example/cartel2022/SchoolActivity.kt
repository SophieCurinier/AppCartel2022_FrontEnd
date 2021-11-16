package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiService
import com.example.cartel2022.model.SchoolAdapter
import kotlinx.android.synthetic.main.activity_school.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchoolActivity : AppCompatActivity(),OnItemSelectedListener {
    private val adapter = SchoolAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_SCHOOL)

        school_recyclerview.adapter = adapter
        school_recyclerview.layoutManager = LinearLayoutManager(this)
        school_recyclerview.setHasFixedSize(true)
        school_recyclerview.adapter = adapter


        lifecycleScope.launch(context = Dispatchers.IO) {
            //All participated schools are shown
            runCatching { ApiService().schoolApiService.findAll().execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        adapter.update(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) { // (3)
                        Toast.makeText(
                            applicationContext,
                            "Error on schools loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }

    //When user clicks on a school button
    override fun onItemSelected(id: Long, name: String) {
        val intent = Intent(this, MatchActivity::class.java).putExtra(EXTRA_SCHOOL, name)
        startActivity(intent)
    }
}