package com.example.agtech.viewmodels

import androidx.lifecycle.ViewModel
import com.example.agtech.domain.CropCategory

class MainViewModel : ViewModel() {

    val cropCategories: Array<String>
        get() = arrayOf("2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017")
}