package com.example.cartel2022.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchApiService {
    @GET("match")
    fun findAll(): Call<List<MatchDto>>

    @GET("match/sport/{sport}")
    fun findBySport(@Path("sport") sport: String): Call<List<MatchDto>>

    @GET("match/ecole/{school}")
    fun findBySchool(@Path("school") school: String): Call<List<MatchDto>>
}