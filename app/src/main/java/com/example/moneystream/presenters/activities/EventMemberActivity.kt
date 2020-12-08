package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_event_member.*
import kotlinx.android.synthetic.main.my_toolbar.view.*

class EventMemberActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_member)

        toolbar_activity_event_member.pageTitle.text = getString(R.string.title_event_member)
    }
}