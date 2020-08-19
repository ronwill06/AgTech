package com.example.agtech.ui

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.app.NavUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agtech.CropSelectionManager
import com.example.agtech.R
import com.example.agtech.listeners.CropCategoryListener
import com.example.agtech.listeners.CropTypeListener
import com.example.agtech.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.viewhholder_crop_item.view.*

class MainFragment: Fragment() {
   private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment =
            MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.done_menu, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_done -> {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, PredictionsFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
            true
        }
        android.R.id.home -> {
            NavUtils.navigateUpFromSameTask(activity!!)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    private class MainRecyclerViewAdapter(
        private val years: Array<String>
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
            holder.configureView(years[position])
        }

        override fun getItemCount(): Int {
            return years.count()
        }
    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.crop_category_spinner.adapter = ArrayAdapter
                .createFromResource(
                    itemView.context,
                    R.array.crop_categories,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }

            itemView.crop_category_spinner.onItemSelectedListener = CropCategoryListener()

            itemView.crop_type_spinner.adapter = ArrayAdapter
                .createFromResource(
                    itemView.context,
                    R.array.crop_types,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }

            itemView.crop_type_spinner.onItemSelectedListener = CropTypeListener()
        }

        fun configureView(year: String) {
            val cropTextView = itemView.findViewById<TextView>(R.id.year_text_view)
            cropTextView.text = year
            itemView.complete_check_box.setOnCheckedChangeListener { _, _ ->  CropSelectionManager.addCropCategoryAndCropType(year) }
        }
    }
}