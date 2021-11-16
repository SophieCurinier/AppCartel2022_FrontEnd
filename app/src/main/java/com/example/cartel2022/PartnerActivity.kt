package com.example.cartel2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.R
import com.example.cartel2022.model.PartnerService

class PartnerActivity : AppCompatActivity(), OnUrlSelectedListener {
    val partnerService = PartnerService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partner)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MENU)

        val recyclerView = findViewById<RecyclerView>(R.id.listPartner) // (2)
        val adapter = PartnerAdapter(this) // (3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        adapter.update(partnerService.findAll())
    }

    override fun onUrlSelected(url: String) {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }
}