package com.example.agtech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.agtech.R
import com.example.agtech.viewmodels.PredictionsViewModel
import kotlinx.android.synthetic.main.fragment_crop_detail.view.*

class PredictionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

        return inflater.inflate(R.layout.fragment_prediction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(PredictionsViewModel::class.java)
        view.predictions_text_view.text = "Canola"
    }

    companion object {
        fun newInstance() = PredictionsFragment()
    }
}