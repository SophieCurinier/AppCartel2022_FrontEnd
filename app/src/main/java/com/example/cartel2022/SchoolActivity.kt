package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SchoolActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schooln)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MESSAGE)
    }
}