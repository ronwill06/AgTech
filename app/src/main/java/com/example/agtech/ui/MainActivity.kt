package com.example.agtech.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.done_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_done -> {
                supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, PredictionsFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()
            true
        }
         android.R.id.home -> {
             NavUtils.navigateUpFromSameTask(this)
             true
         }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
