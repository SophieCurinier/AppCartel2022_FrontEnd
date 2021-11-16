package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ApiService
import com.example.cartel2022.model.MatchAdapter
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

        //Depending on where we come from showed match are differents
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //If we have already selected a sport, only matchs of this sport is shown
        if (intent.getStringExtra(EXTRA_SPORT) != null){
            title = intent.getStringExtra(EXTRA_SPORT)
            val sportName : String = intent.getStringExtra(EXTRA_SPORT).toString()
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiService().matchApiService.findBySport(sportName).execute() }
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
        //If we have already selected a school, only matchs where this school partipated is shown
        else if (intent.getStringExtra(EXTRA_SCHOOL) != null){
            title = intent.getStringExtra(EXTRA_SCHOOL)
            val schoolName : String = intent.getStringExtra(EXTRA_SCHOOL).toString()
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiService().matchApiService.findBySchool(schoolName).execute() }
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
        //Else we come from home screen and shown planning, so all matchs is shown
        else {
            title = intent.getStringExtra(EXTRA_MENU)
            lifecycleScope.launch(context = Dispatchers.IO) { // (1)
                runCatching { ApiService().matchApiService.findAll().execute() } // (2)
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
    }
}