package com.example.cartel2022.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {
    val schoolApiService : SchoolApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(SchoolApiService::class.java)
    }

    val sportApiService : SportApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(SportApiService::class.java)
    }

    val matchApiService : MatchApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(MatchApiService::class.java)
    }

}