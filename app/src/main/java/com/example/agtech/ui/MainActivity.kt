package com.example.agtech.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.agtech.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.container,
                MainFragment.newInstance()
            )
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_done -> {
                supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, PredictionsFragment.newInstance())
                    ?.commit()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
