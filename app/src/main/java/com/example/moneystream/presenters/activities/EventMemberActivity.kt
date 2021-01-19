package com.example.moneystream.presenters.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.MemberListFragment
import kotlinx.android.synthetic.main.activity_event_member.*
import kotlinx.android.synthetic.main.my_toolbar.view.*

class EventMemberActivity : BaseActivity(), MemberListFragment.FragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_member)

        toolbar_activity_event_member.pageTitle.text = getString(R.string.title_event_member)

        //MemberListFragment()
        this.replaceFragment()

        val fab: View = findViewById(R.id.member_list_fab)
        fab.setOnClickListener { view: View? ->
            onClickFab()
        }
    }

    private fun replaceFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val memberListFragment = MemberListFragment()
        transaction.replace(R.id.member_list_container, memberListFragment)
        transaction.commit()
    }

    override fun onClickFab() {
        Toast.makeText(this, "Clicked: fab", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@EventMemberActivity, InviteActivity::class.java)
        startActivity(intent)
    }

    override fun onClickListItem() {
        Toast.makeText(this, "Clicked: List", Toast.LENGTH_SHORT).show()
    }
}