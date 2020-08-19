package com.example.agtech.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.agtech.R
import com.example.agtech.domain.CropCategory
import com.example.agtech.viewmodels.PredictionsViewModel
import kotlinx.android.synthetic.main.fragment_crop_detail.view.*
import kotlin.random.Random

class PredictionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prediction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(PredictionsViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        val pos = Random.nextInt(0, CropCategory.values().size - 1)
        view?.predictions_text_view?.text = CropCategory.values()[pos].toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.dismiss_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        R.id.action_dismiss -> {
            activity?.supportFragmentManager?.popBackStackImmediate()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun newInstance() = PredictionsFragment()
    }
}