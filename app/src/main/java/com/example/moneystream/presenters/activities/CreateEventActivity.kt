package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BaseFormFragment
import com.example.moneystream.presenters.fragments.EventFormFragment
import com.example.moneystream.presenters.fragments.InputHistoryFragment
import com.example.moneystream.presenters.fragments.OurHistoryFormFragment

open class CreateEventActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.event_form_container, EventFormFragment())
        fragmentTransaction.commit()
    }
}