package com.example.cartel2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : AppCompatActivity(), OnItemSelectedListener {

    private val adapter = ContactsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MENU)


        contacts_recyclerview.layoutManager = LinearLayoutManager(this)
        contacts_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        contacts_recyclerview.setHasFixedSize(true)
        contacts_recyclerview.adapter = adapter

        adapter.update(ContactsService.findAll())
    }

    override fun onItemSelected(id: Long, tel: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse(tel));
        startActivity(intent)
    }
}