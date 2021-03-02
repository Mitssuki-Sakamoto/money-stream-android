package com.example.moneystream.presenters.activities

import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BudgetFormFragment

class EditBudgetActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_budget)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.budget_form_container, BudgetFormFragment())
        fragmentTransaction.commit()
    }
}