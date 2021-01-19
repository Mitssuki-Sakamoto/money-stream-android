package com.example.moneystream.presenters.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BudgetFormFragment
import kotlinx.android.synthetic.main.fragment_budget_form.*
import java.util.*

class EditBudgetActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_budget)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.budget_form_container, BudgetFormFragment())
        fragmentTransaction.commit()
    }
}