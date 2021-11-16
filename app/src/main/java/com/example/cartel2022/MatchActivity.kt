package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiServices
import kotlinx.android.synthetic.main.activity_match.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        val adapter = MatchAdapter()

        match_recyclerview.layoutManager = LinearLayoutManager(this)
        match_recyclerview.setHasFixedSize(true)
        match_recyclerview.adapter = adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (intent.getStringExtra(EXTRA_SPORT) != null){
            title = intent.getStringExtra(EXTRA_SPORT)
            val sportName : String = intent.getStringExtra(EXTRA_SPORT).toString()
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiServices().matchsApiService.findBySport(sportName).execute() }
                    .onSuccess {
                        withContext(context = Dispatchers.Main) { // (3)
                            adapter.update(it.body() ?: emptyList())
                        }
                    }
                    .onFailure {
                        withContext(context = Dispatchers.Main) { // (3)
                            Toast.makeText(
                                applicationContext,
                                "Error on matchs loading $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
        else if (intent.getStringExtra(EXTRA_SCHOOL) != null){
            title = intent.getStringExtra(EXTRA_SCHOOL)
            val schoolName : String = intent.getStringExtra(EXTRA_SCHOOL).toString()
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiServices().matchsApiService.findBySchool(schoolName).execute() }
                    .onSuccess {
                        withContext(context = Dispatchers.Main) { // (3)
                            adapter.update(it.body() ?: emptyList())
                        }
                    }
                    .onFailure {
                        withContext(context = Dispatchers.Main) { // (3)
                            Toast.makeText(
                                applicationContext,
                                "Error on matchs loading $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
        else {
            title = intent.getStringExtra(EXTRA_MENU)
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiServices().matchsApiService.findAll().execute() } // (2)
                    .onSuccess {
                        withContext(context = Dispatchers.Main) { // (3)
                            adapter.update(it.body() ?: emptyList())
                            Toast.makeText(
                                applicationContext,
                                "Wesh $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    .onFailure {
                        withContext(context = Dispatchers.Main) { // (3)
                            Toast.makeText(
                                applicationContext,
                                "Error on matchs loading $it",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }





    }

}
