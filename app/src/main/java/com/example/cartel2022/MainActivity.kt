package com.example.cartel2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val EXTRA_SPORT = "com.example.Cartel2022.SPORT"
const val EXTRA_SCHOOL = "com.example.Cartel2022.SCHOOL"
const val EXTRA_MATCHSCHOOL = "com.example.Cartel2022.MATCHSCOOL"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }
    /** Called when the user taps the Sport button */
    fun switchSport(view: View) {
        val editText = findViewById<Button>(R.id.buttonSport)
        val message = editText.text.toString()
        val intent = Intent(this, SportActivity::class.java).apply {
            putExtra(EXTRA_SPORT, message)
        }
        startActivity(intent)
    }
    // Called when user clicks on Sport button //
    fun switchRanking(view: View) {
        val editText = findViewById<Button>(R.id.buttonWebSite)
        val message = editText.text.toString()
        val intent = Intent(this, RankingActivity::class.java).apply {
            putExtra(EXTRA_SPORT, message)
        }
        startActivity(intent)
    }
    //Called when the user clicks on the Ranking button//
    // Called when the user taps the Sport button //
    fun switchPlanning(view: View) {
        val editText = findViewById<Button>(R.id.buttonInstagram)
        val message = editText.text.toString()
        val intent = Intent(this, PlanningActivity::class.java).apply {
            putExtra(EXTRA_SPORT, message)
        }
        startActivity(intent)
    }
    fun switchSchool(view: View) {
        val editText = findViewById<Button>(R.id.buttonFacebook)
        val message = editText.text.toString()
        val intent = Intent(this, SchoolActivity::class.java).apply {
            putExtra(EXTRA_SCHOOL, message)
        }
        startActivity(intent)
    }


}