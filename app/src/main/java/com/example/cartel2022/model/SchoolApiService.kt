package com.example.cartel2022.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SchoolApiService {
    @GET("ecole")
    fun findAll(): Call<List<SchoolDto>>

    @GET("ecole/{id}")
    fun findById(@Path("id") id: Long): Call<SchoolDto>
}