package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiService
import com.example.cartel2022.model.SportAdapter
import kotlinx.android.synthetic.main.activity_sport.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SportActivity : AppCompatActivity(), OnItemSelectedListener {

    private val adapter = SportAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_SPORT)

        sport_recyclerview.layoutManager = LinearLayoutManager(this)
        sport_recyclerview.setHasFixedSize(true)
        sport_recyclerview.adapter = adapter

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiService().sportApiService.findAll().execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        adapter.update(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) { // (3)
                        Toast.makeText(
                            applicationContext,
                            "Error on sports loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }


    override fun onItemSelected(id: Long, name: String) {
        val intent = Intent(this, MatchActivity::class.java).apply {
            putExtra(EXTRA_SPORT, name) }
            startActivity(intent)
        }
}

