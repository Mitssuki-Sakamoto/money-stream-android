package com.example.moneystream.presenters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.moneystream.R
import com.example.moneystream.presenters.activities.BaseActivity
import com.example.moneystream.presenters.fragments.EventListFragment

class MainActivity : BaseActivity(), EventListFragment.FragmentListener {
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

    override fun onClickFab() {
        Toast.makeText(this, "Clicked: fab", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, CreateEventActivity::class.java)
        startActivity(intent)
    }

    override fun onClickListItem() {
        Toast.makeText(this, "Clicked: List", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, EventActivity::class.java)
        startActivity(intent)
    }
}
