package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.activities.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}