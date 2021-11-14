package com.example.cartel2022.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SchoolApiService {
    @GET("school")
    fun findAll(): Call<List<SchoolDto>>

    @GET("school/{id}")
    fun findById(@Path("id") id: Long): Call<SchoolDto>
}