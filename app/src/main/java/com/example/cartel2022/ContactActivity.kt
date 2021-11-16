package com.example.cartel2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartel2022.model.ContactAdapter
import com.example.cartel2022.model.ContactService
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactActivity : AppCompatActivity(), OnItemSelectedListener {

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MENU)


        contacts_recyclerview.layoutManager = LinearLayoutManager(this)
        contacts_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        contacts_recyclerview.setHasFixedSize(true)
        contacts_recyclerview.adapter = adapter

        adapter.update(ContactService.findAll())
    }

    override fun onItemSelected(id: Long, tel: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse(tel));
        startActivity(intent)
    }
}