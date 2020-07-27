package com.example.agtech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agtech.domain.CropCategory
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: Fragment() {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.mainRecyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = MainRecyclerViewAdapter(CropCategory.values())
        view.mainRecyclerView.adapter = adapter
        return view
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
        }

        override fun getItemCount(): Int {
            return crops.count()
        }
    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun configureView(cropCategory: CropCategory) {
            val cropTextView = itemView.findViewById<TextView>(R.id.crop_type_text_view)
            cropTextView.text = cropCategory.name
        }
    }
}