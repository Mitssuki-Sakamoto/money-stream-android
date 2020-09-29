package com.example.moneystream

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<ListView>(R.id.listViewEvent) as ListView
        val tmpnames = arrayListOf<String>("熱海", "沖縄")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tmpnames)
        list!!.adapter = adapter
        list.setOnItemClickListener {parent, view, position, id ->
            onClick(list)
        }
    }

    fun onClick(view: View?) {
        val intent: Intent = Intent(this, EventActivity::class.java)
        startActivity(intent)
    }
}