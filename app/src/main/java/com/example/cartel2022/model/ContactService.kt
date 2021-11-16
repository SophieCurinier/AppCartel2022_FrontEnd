package com.example.cartel2022.model

class ContactService {
    companion object {
        // Contacts
        val CONTACTS: List<ContactDto> = listOf(
            ContactDto(1, "Président", "Si les VP ne sont pas disponibles", "Ryan KAOUKEB", "07 67 40 42 36"),
            ContactDto(2, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(3, "Vice-Président", "Relation avec les délégations", "Philippe JESTIN", "06 87 77 40 45"),
            ContactDto(4, "Vice-Président", "Sports, Soirées", "Baptiste ABÉLÈS", "06 87 77 40 46"),
            ContactDto(5, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(6, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(7, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(8, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(9, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(10, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44")


        )

        fun findAll() = CONTACTS.sortedBy { it.poste }
    }

}