package com.example.moneystream.presenters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.moneystream.R
import java.lang.NullPointerException

class EventDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val image_buttons = listOf<ImageView>(
            findViewById(R.id.detail_member_image),
            findViewById(R.id.detail_invite_image),
            findViewById(R.id.detail_exit_image)
        )
        image_buttons[0].setOnClickListener { view -> onClickImage(0) }
        image_buttons[1].setOnClickListener { view -> onClickImage(1) }
        image_buttons[2].setOnClickListener { view -> onClickImage(2) }
    }

    fun onClickImage(i: Int) {
        var intent: Intent = Intent()
        when (i) {
            0 -> {
                Toast.makeText(this, "Clicked: member", Toast.LENGTH_SHORT).show()
                intent = Intent(this, EventMemberActivity::class.java)
            }
            1 -> {
                Toast.makeText(this, "Clicked: invite", Toast.LENGTH_SHORT).show()
                intent = Intent(this, InviteActivity::class.java)
            }
            2 -> {
                Toast.makeText(this, "Clicked: exit", Toast.LENGTH_SHORT).show()
            }
        }
        startActivity(intent)
    }
}