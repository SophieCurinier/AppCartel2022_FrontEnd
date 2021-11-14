package com.example.cartel2022.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchApiService {
    @GET("match")
    fun findAll(): Call<List<MatchDto>>

    @GET("match/{id}")
    fun findById(@Path("id") id: Long): Call<MatchDto>
}