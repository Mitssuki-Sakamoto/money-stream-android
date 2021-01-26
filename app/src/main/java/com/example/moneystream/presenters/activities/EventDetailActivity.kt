package com.example.moneystream.presenters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_event_detail.*
import kotlinx.android.synthetic.main.my_toolbar.view.*
import java.lang.NullPointerException

class EventDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        toolbar_activity_event_detail.pageTitle.text = getString(R.string.title_event_detail)

        val image_buttons = listOf<ImageView>(
            findViewById(R.id.detail_member_image),
            findViewById(R.id.detail_invite_image),
            findViewById(R.id.detail_exit_image)
        )
        image_buttons[0].setOnClickListener { view -> onClickMember() }
        image_buttons[1].setOnClickListener { view -> onClickInvite() }
        image_buttons[2].setOnClickListener { view -> onClickExit() }
    }

    private fun onClickMember() {
        Toast.makeText(this, "Clicked: member", Toast.LENGTH_SHORT).show()
        intent = Intent(this, EventMemberActivity::class.java)
        startActivity(intent)
    }

    private fun onClickInvite() {
        Toast.makeText(this, "Clicked: invite", Toast.LENGTH_SHORT).show()
        intent = Intent(this, InviteActivity::class.java)
        startActivity(intent)
    }

    private fun onClickExit() {
        Toast.makeText(this, "Clicked: exit", Toast.LENGTH_SHORT).show()
        finish()
    }

}