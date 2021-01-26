package com.example.moneystream.presenters.activities

import android.content.Intent
import android.media.Image
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

        val member_button: ImageView = findViewById(R.id.detail_member_image)
        member_button.setOnClickListener { onClickMember() }

        val invite_button: ImageView = findViewById(R.id.detail_invite_image)
        invite_button.setOnClickListener { onClickInvite() }

        val exit_button: ImageView = findViewById(R.id.detail_exit_image)
        exit_button.setOnClickListener{ onClickExit()}

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