package com.example.agtech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.agtech.domain.CropCategory

class MainViewModel : ViewModel() {

    val cropCategories: Array<CropCategory>
        get() = CropCategory.values()
}