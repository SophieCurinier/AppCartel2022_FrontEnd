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

        //* var buttonBookmarks = findViewById<Button>(R.id.buttonSport) as Button
        //buttonBookmarks.setOnClickListener{
        //    Toast.makeText(this, "Works", Toast.LENGTH_LONG).show()
        //}
        }
    /** Called when the user taps the Sport button */
    fun switchSport(view: View) {
        val editText = findViewById<Button>(R.id.buttonSport)
        val message = editText.text.toString()
        Toast.makeText(this, "message", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MatchActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }






}