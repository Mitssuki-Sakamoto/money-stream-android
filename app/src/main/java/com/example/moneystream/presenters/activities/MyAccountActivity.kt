package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_invite.*
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.my_toolbar.view.*

class MyAccountActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        toolbar_activity_my_account.pageTitle.text = getString(R.string.title_my_account)
    }
}