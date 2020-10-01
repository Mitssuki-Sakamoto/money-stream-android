package com.example.moneystream

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edit_budget_history.*

class EditBudgetHistory : AppCompatActivity() {
    private val spinerItems = arrayOf("全体支出（予算内）", "全体残高（予算外）", "個人の財布")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_budget_history)

        val syukkinnmotoAdapter = ArrayAdapter(applicationContext, R.layout.spinner_view, spinerItems)
        syukkinnmotoAdapter.setDropDownViewResource(R.layout.spinner_view)
        spinnerSyukkinnmoto.adapter = syukkinnmotoAdapter
    }
}