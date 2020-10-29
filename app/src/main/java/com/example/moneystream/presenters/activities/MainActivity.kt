package com.example.moneystream.presenters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.moneystream.R
import com.example.moneystream.presenters.activities.BaseActivity
import com.example.moneystream.presenters.fragments.EventListFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.replaceFragment()
    }

    private fun replaceFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val eventListFragment = EventListFragment()
        transaction.replace(R.id.event_list_container, eventListFragment)
        transaction.commit()
    }

}
