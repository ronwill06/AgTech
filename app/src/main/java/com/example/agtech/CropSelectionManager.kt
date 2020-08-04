package com.example.agtech

object CropSelectionManager {
    private val cropSelections = mutableMapOf<String, Map<String, String>>()
    var cropCategory: String? = null
    var cropType: String? = null

    fun addCropCategoryAndCropType(year: String) {
        if (cropCategory != null && cropType != null) {
            cropSelections[year] = mapOf("category" to cropCategory!!, "type" to cropType!!)
        }
    }
}