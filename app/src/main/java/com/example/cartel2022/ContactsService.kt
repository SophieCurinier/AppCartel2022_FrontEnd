package com.example.cartel2022

class ContactsService {
    companion object {
        // Contacts
        val CONTACTS: List<ContactOrga> = listOf(
            ContactOrga(1, "Président", "Si les VP ne sont pas disponibles", "Ryan KAOUKEB", "07 67 40 42 36"),
            ContactOrga(2, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(3, "Vice-Président", "Relation avec les délégations", "Philippe JESTIN", "06 87 77 40 45"),
            ContactOrga(4, "Vice-Président", "Sports, Soirées", "Baptiste ABÉLÈS", "06 87 77 40 46"),
            ContactOrga(5, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(6, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(7, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(8, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(9, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactOrga(10, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44")


        )

        fun findById(id: Long) = CONTACTS.firstOrNull { it.id == id}

        fun findAll() = CONTACTS.sortedBy { it.poste }
    }

}