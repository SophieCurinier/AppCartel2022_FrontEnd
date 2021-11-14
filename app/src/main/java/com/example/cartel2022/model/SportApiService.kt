package com.example.cartel2022.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SportApiService {
    @GET("sport")
    fun findAll(): Call<List<SportDto>>

    @GET("sport/{id}")
    fun findById(@Path("id") id: Long): Call<SportDto>
}