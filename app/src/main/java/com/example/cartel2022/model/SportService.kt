package com.example.cartel2022.model

class SportService {
    companion object {
        // Fake School
        val SCHOOLS: List<SchoolDto> = listOf(
            SchoolDto(1, "EMSE"),
            SchoolDto(2, "Ales"),
            SchoolDto(3,"Albi")
        )

        val SPORTS: List<SportDto> = listOf(
            SportDto(1,"Football féminin"),
            SportDto(2,"Football masculin"),
            SportDto(3,"Rugby féminin"),
            SportDto(4,"Rugby masculin")
        )
    }

    fun findById(id: Long) = SPORTS.firstOrNull { it.id == id}

    fun findAll() = SPORTS.sortedBy { it.name }
}