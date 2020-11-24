package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BaseFormFragment
import com.example.moneystream.presenters.fragments.InputHistoryFragment
import com.example.moneystream.presenters.fragments.OurHistoryFormFragment

open class CreateEventActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val baseFormFragment = OurHistoryFormFragment() //InputHistoryFragment() //BaseFormFragment()
        // 試作でBaseFormFragmentにactivity_create_eventに載せるformを作っちゃってます．
        // 本来このCreateEventActivityのformはfragmentである必要はないので，BaseFormFragmentの内容はあとでactivity_create_eventに移植し直します．．
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, baseFormFragment)
        fragmentTransaction.commit()
    }
}