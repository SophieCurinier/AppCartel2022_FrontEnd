package com.example.cartel2022.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServices {
    val schoolsApiService : SchoolApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(SchoolApiService::class.java)
    }

    val sportsApiService : SportApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(SportApiService::class.java)
    }

    val matchsApiService : MatchApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(MatchApiService::class.java)
    }

    val matchsSportApiService : MatchSportApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://cartel2022.cleverapps.io/api/")
            .build()
            .create(MatchSportApiService::class.java)
    }
}