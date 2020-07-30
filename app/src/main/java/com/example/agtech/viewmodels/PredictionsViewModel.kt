package com.example.agtech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.agtech.HttpClient

class PredictionsViewModel: ViewModel() {

    private val predictionsService = HttpClient.predictionsService

}