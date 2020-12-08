package com.example.moneystream.presenters.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.EventListFragment
import com.example.moneystream.presenters.fragments.EventListFragment.FragmentListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_toolbar.*
import kotlinx.android.synthetic.main.my_toolbar.view.*

class MainActivity : BaseActivity(),FragmentListener {
    /*
    private val eventListFragmentListener: FragmentListener = object:FragmentListener{
        override fun onClickFab() {
            Toast.makeText(this@MainActivity, "Clicked: fab", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, CreateEventActivity::class.java)
            startActivity(intent)
        }

        override fun onClickListItem() {
            Toast.makeText(this@MainActivity, "Clicked: List", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, EventActivity::class.java)
            startActivity(intent)
        }
    }

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.replaceFragment()

        toolbar_activity_main.pageTitle.text = getString(R.string.title_main)
        image_back.visibility = View.GONE

        val fab: View = findViewById(R.id.event_list_fab)
        fab.setOnClickListener { view: View? ->
            onClickFab()
        }
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
