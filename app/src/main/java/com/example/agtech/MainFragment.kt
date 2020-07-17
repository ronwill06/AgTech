package com.example.agtech

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        activity?.let {
            view.mainRecyclerView.layoutManager = LinearLayoutManager(it)
            val adapter = MainRecyclerViewAdapter(it, listOf("Corn", "Rice", "Peas"))
            view.mainRecyclerView.adapter = adapter
        }
        return view
    }

    private class MainRecyclerViewAdapter(private val context: Context, private val crops: List<String>): RecyclerView.Adapter<MainViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
           val view = LayoutInflater.from(context)
                .inflate(R.layout.viewhholder_crop_item, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.configureView(crops[position])
        }

        override fun getItemCount(): Int {
           return crops.size
        }
    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun configureView(cropText: String) {
            val cropTextView = itemView.findViewById<TextView>(R.id.crop_type_text_view)
            cropTextView.text = cropText
        }
    }
}