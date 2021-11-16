package com.example.cartel2022.model

class ContactService {
    companion object {
        // Contacts
        val CONTACTS: List<ContactDto> = listOf(
            ContactDto(1, "Président", "Si les VP ne sont pas disponibles", "Ryan KAOUKEB", "07 67 40 42 36"),
            ContactDto(2, "Vice-Président", "Hébergement, Transports, Restauration", "Pierre MAINDRON", "06 87 77 40 44"),
            ContactDto(3, "Vice-Président", "Relation avec les délégations", "Philippe JESTIN", "06 87 77 40 45"),
            ContactDto(4, "Vice-Président", "Sports, Soirées", "Baptiste ABÉLÈS", "06 87 77 40 46"),
            ContactDto(5, "Responsable Sports", "Litige important durant une compétition ou question sur un règlement sportif", "Julian Paquerot", "06 40 16 41 03"),
            ContactDto(6, "Responsable Hébergement", "Hébergements Hors Saint-Étienne", "Ajejandro Lopez", "07 67 24 70 81"),
            ContactDto(7, "Responsable Hébergement", "Hébergements dans Saint-Étienne", "Alan Iziquiel", "06 45 98 98 76"),
            ContactDto(8, "Responsabe Restauration", "Problème de restauration","Cassiopée André", "06 87 77 40 44"),
            ContactDto(9, "Responsable Transports", "Problème de transports en journée", "Matthieu Godillon", "06 87 77 40 44"),
            ContactDto(10, "Responsable Transports", "Problème de transport en soirée", "Raphaël Klaja", "06 29 53 42 51")


        )

        fun findAll() = CONTACTS.sortedBy { it.id }
    }

}