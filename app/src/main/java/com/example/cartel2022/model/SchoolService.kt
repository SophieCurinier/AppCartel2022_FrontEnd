package com.example.cartel2022.model

class SchoolService {
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

    fun findById(id: Long) = SCHOOLS.firstOrNull { it.id == id}

    fun findAll() = SCHOOLS.sortedBy { it.name }
}
