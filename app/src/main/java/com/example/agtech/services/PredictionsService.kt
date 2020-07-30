package com.example.agtech.services

import com.example.agtech.domain.Crops
import retrofit2.Call
import retrofit2.http.GET

interface PredictionsService {
    @GET("predictions")
    fun getPredictions(): Call<Crops>
}