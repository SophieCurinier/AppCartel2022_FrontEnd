package com.example.cartel2022

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.ContactsService.Companion.findById
import kotlinx.android.synthetic.main.activity_contacts.*
import kotlinx.android.synthetic.main.contact_item.*
import java.util.jar.Manifest

class ContactsActivity : AppCompatActivity(), OnItemSelectedListener {

    private val adapter = ContactsAdapter(this)
    private val requestCall = 1

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

        setContentView(R.layout.contact_item)
        lateinit var button: Button
        button = findViewById<Button>(R.id.numero)
        button.setOnClickListener {
            makePhoneCall()
        }





    }

    override fun onItemSelected(id: Long, tel: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse(tel));
        startActivity(intent)
    }


    private fun makePhoneCall(){
        val number: String = numero.text.toString()


        val dial = "tel:$number"

        startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == requestCall) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall()
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show()
            }
        }
    }
}