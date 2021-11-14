package com.example.cartel2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

const val EXTRA_SPORT = "com.example.Cartel2022.SPORT"
const val EXTRA_SCHOOL = "com.example.Cartel2022.SCHOOL"
const val EXTRA_MATCHSCHOOL = "com.example.Cartel2022.MATCHSCOOL"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_social_network) {
            startActivity(Intent(this, SocialNetworkActivity::class.java).apply {
                putExtra(EXTRA_SPORT, "Réseaux Sociaux")})
        }
        if (id == R.id.action_urgency_contact) {
            startActivity(Intent(this, ContactsActivity::class.java).apply {
                putExtra(EXTRA_SPORT, "Contact des responsables")})
        }
        if (id == R.id.action_map) {
            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra(EXTRA_SPORT, "Plan")})
        }
        if (id == R.id.action_setting){
            startActivity(Intent(this, SettingActivity::class.java).apply {
                putExtra(EXTRA_SPORT, "A propos de nous et paramètre")})
        }

        return super.onOptionsItemSelected(item)

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