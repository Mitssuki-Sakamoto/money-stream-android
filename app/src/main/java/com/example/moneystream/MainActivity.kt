package com.example.moneystream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeButton = findViewById<Button>(R.id.home_btn)
        val inputButton = findViewById<Button>(R.id.input_btn)
        val ownHistoryButton = findViewById<Button>(R.id.own_history_btn)
        val requestButton = findViewById<Button>(R.id.request_btn)

        val budgetFragment = BudgetFragment()
        val inputFragment = InputFragment()
        val ownHistoryFragment = OwnHistoryFragment()
        val requestFragment = RequestFragment()
        replaceFragment(budgetFragment)

        homeButton.setOnClickListener {
            replaceFragment(budgetFragment)
        }
        inputButton.setOnClickListener {
            replaceFragment(inputFragment)
        }
        ownHistoryButton.setOnClickListener {
            replaceFragment(ownHistoryFragment)
        }
        requestButton.setOnClickListener {
            replaceFragment(requestFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}