package com.example.moneystream.presenters.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.moneystream.R
import kotlinx.android.synthetic.main.my_toolbar.view.*

open class BaseActivity : AppCompatActivity() {
    var toolbar: Toolbar = findViewById(R.id.toolbar)
    fun init_toolbar(back: Int=View.VISIBLE, title: Int = View.VISIBLE, account: Int=View.VISIBLE, detail: Int=View.VISIBLE) {
        toolbar.image_back.visibility = back
        toolbar.pageTitle.visibility = title
        toolbar.image_myaccount.visibility = account
        toolbar.image_detail.visibility = detail
    }
}