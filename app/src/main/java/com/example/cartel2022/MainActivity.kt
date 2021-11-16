package com.example.cartel2022

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate

//Intent after pushing on one of sport buttons in sport activity
const val EXTRA_SPORT = "com.example.Cartel2022.SPORT"
//Intent after pushing on one of school buttons in school activity
const val EXTRA_SCHOOL = "com.example.Cartel2022.SCHOOL"
//Intent after clicking on planning button
const val EXTRA_PLANNING = "com.example.Cartel2022.PLANNING"
//Intent after clicking on one of menu button in menu option
const val EXTRA_MENU = "com.example.Cartel2022.MENU"


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
                putExtra(EXTRA_MENU, "Réseaux Sociaux")})
        }
        if (id == R.id.action_urgency_contact) {
            startActivity(Intent(this, ContactsActivity::class.java).apply {
                putExtra(EXTRA_MENU, "Contact des responsables")})
        }
        if (id == R.id.action_partner){
            startActivity(Intent(this, PartnerActivity::class.java).apply {
                putExtra(EXTRA_MENU, "Partenaire")})
        }
        if (id == R.id.action_setting){
            startActivity(Intent(this, SettingActivity::class.java).apply {
                putExtra(EXTRA_MENU, "A propos de nous")})
        }

        return super.onOptionsItemSelected(item)

    }

    // Called when the user taps the Sport button */
    fun switchSport(view: View) {
        val message = findViewById<Button>(R.id.buttonSport).text.toString()
        val intent = Intent(this, SportActivity::class.java).apply {
            putExtra(EXTRA_SPORT, message)
        }
        startActivity(intent)
    }
    //Called when the user clicks on the Ranking button
    fun switchPlanning(view: View) {
        val editText = findViewById<Button>(R.id.buttonPlanning)
        val message = editText.text.toString()
        val intent = Intent(this, PlanningActivity::class.java).apply {
            putExtra(EXTRA_PLANNING, message)
        }
        startActivity(intent)
    }
    //Called when the user clicks on the School button
    fun switchSchool(view: View) {
        val editText = findViewById<Button>(R.id.buttonSchool)
        val message = editText.text.toString()
        val intent = Intent(this, SchoolActivity::class.java).apply {
            putExtra(EXTRA_SCHOOL, message)
        }
        startActivity(intent)
    }

    //Called when the user clicks on the map button
    fun switchMaps(view: View) {
        val editText = findViewById<Button>(R.id.buttonMap)
        val message = editText.text.toString()
        val intent = Intent(this, MapsActivity::class.java).apply {
            putExtra(EXTRA_MENU, message)
        }
        startActivity(intent)
    }


}