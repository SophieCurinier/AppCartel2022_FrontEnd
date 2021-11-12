package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.Cartel2022.SCREEN"

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
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
    // Called when user clicks on Sport button //
    fun switchRanking(view: View) {
        val editText = findViewById<Button>(R.id.buttonRanking)
        val message = editText.text.toString()
        val intent = Intent(this, RankingActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
    //Called when the user clicks on the Ranking button//
    // Called when the user taps the Sport button //
    fun switchPlanning(view: View) {
        val editText = findViewById<Button>(R.id.buttonPlanning)
        val message = editText.text.toString()
        val intent = Intent(this, PlanningActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
    fun switchSchool(view: View) {
        val editText = findViewById<Button>(R.id.buttonSchool)
        val message = editText.text.toString()
        val intent = Intent(this, SchoolActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }


}