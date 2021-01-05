package com.example.moneystream.presenters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BudgetFormFragment
import com.example.moneystream.presenters.fragments.MyHistoryFormFragment

class InputBudgetActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_budget)

        val budgetFormFragment = BudgetFormFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.budget_form_container, budgetFormFragment)
        fragmentTransaction.commit()
    }
}