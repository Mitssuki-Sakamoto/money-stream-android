package com.example.moneystream.presenters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.moneystream.R
import com.example.moneystream.presenters.activities.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val list = findViewById<ListView>(R.id.listViewEvent) as ListView
    val tmpnames = arrayListOf<String>("熱海", "沖縄")

}
