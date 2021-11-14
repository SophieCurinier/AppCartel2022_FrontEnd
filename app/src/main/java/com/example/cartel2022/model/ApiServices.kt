package com.example.cartel2022.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServices {
    val schoolsApiService : SchoolApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("http://localhost:8080/")
            .build()
            .create(SchoolApiService::class.java)
    }
}