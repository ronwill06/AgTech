package com.example.agtech.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agtech.R
import com.example.agtech.domain.CropCategory
import com.example.agtech.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: Fragment() {
   private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment =
            MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.mainRecyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val adapter = MainRecyclerViewAdapter(viewModel.cropCategories)
        view.mainRecyclerView.adapter = adapter
    }


    private class MainRecyclerViewAdapter(
        private val crops: Array<CropCategory>
    ) : RecyclerView.Adapter<MainViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
            return MainViewHolder(view)
        }

        override fun getItemViewType(position: Int): Int {
            super.getItemViewType(position)
            return R.layout.viewhholder_crop_item
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.configureView(crops[position])
            holder.itemView.setOnClickListener {  }
        }

        override fun getItemCount(): Int {
            return crops.count()
        }
    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun configureView(cropCategory: CropCategory) {
            val cropTextView = itemView.findViewById<TextView>(R.id.crop_type_text_view)
            cropTextView.text = cropCategory.name
        }

        override fun onClick(p0: View?) {
            val activity = p0?.context as AppCompatActivity
            activity.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, PredictionsFragment.newInstance())
                ?.commit()
        }
    }
}