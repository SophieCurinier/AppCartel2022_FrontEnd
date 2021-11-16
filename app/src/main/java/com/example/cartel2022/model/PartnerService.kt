package com.example.cartel2022.model

import com.example.cartel2022.R

class PartnerService {

    companion object{
        //Partner rank,image_id and url
        val PARTNERS: List<PartnerDto> = listOf(
            PartnerDto(1, R.drawable.ic_partner_bnp,"https://mabanque.bnpparibas/fr/vos-besoins/votre-situation/etudiants"),
            PartnerDto(2,R.drawable.ic_logo_pumpkin,"https://pumpkin-app.co/"),
            PartnerDto(3, R.drawable.ic_partner_sainte,"https://www.saint-etienne-metropole.fr/"),
            PartnerDto(4,R.drawable.ic_partner_emse,"https://www.mines-stetienne.fr/"),
            PartnerDto(4, R.drawable.ic_partner_alma,"https://www.sources-alma.com/fr/"),
            PartnerDto(5,R.drawable.ic_partner_eurovia,"https://www.eurovia.fr/")
        )

    }

    fun findAll() = PARTNERS.sortedBy{it.rank}

}