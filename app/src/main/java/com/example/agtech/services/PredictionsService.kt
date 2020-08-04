package com.example.agtech.services

import com.example.agtech.domain.CropType
import retrofit2.Call
import retrofit2.http.GET

interface PredictionsService {
    @GET("predictions")
    fun getPredictions(): Call<CropType>
}