package com.example.cartel2022.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartel2022.OnItemSelectedListener
import com.example.cartel2022.R

class ContactAdapter(val listener: OnItemSelectedListener) : RecyclerView.Adapter<ContactAdapter.ContactsViewHolder>() {

    inner class ContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poste: TextView = view.findViewById(R.id.Poste1)
        val circonstance: TextView = view.findViewById(R.id.Circonstance1)
        val nom: TextView = view.findViewById(R.id.nom1)
        val numero: TextView = view.findViewById(R.id.numero1)
    }

    private val items = mutableListOf<ContactDto>()

    fun update(contacts: List<ContactDto>) {
        items.clear()
        items.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {  // (7)
        val contact = items[position]
        holder.apply {
            poste.text = contact.poste
            circonstance.text = contact.circonstance
            nom.text = contact.nom
            numero.text = contact.numero
            itemView.setOnClickListener { listener.onItemSelected(contact.id, contact.numero) }

        }
    }
}