package com.example.moneystream.presenters.activities

import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.EventFormFragment

open class CreateEventActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.event_form_container, EventFormFragment())
        fragmentTransaction.commit()
    }
}