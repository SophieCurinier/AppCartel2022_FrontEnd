package com.example.cartel2022.model

import android.widget.Toast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchSportApiService {
    @GET("match")
    fun findAll(): Call<List<MatchDto>>

    @GET("match/sport/{name}")
    fun findBySport(@Path("name", encoded = true) name : String): Call<List<MatchDto>>
}