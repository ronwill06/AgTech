package com.example.agtech.listeners

import android.view.View
import android.widget.AdapterView
import com.example.agtech.CropSelectionManager

class CropTypeListener: AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        val cropType = parent?.getItemAtPosition(pos) as String
        CropSelectionManager.cropType = cropType
    }
}