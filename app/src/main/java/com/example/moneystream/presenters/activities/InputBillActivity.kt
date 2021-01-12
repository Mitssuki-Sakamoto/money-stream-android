package com.example.moneystream.presenters.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.fragment_budget_form.*
import java.util.*

class InputBillActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_bill)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        date.setText("%s-%s-%s".format(year, month, day))

        date.setOnClickListener {
            val dtp = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                    date.setText("")
                    date.setText("%s-%s-%s".format(y, m+1, d))
                    //Toast.makeText(context!!, "日付を選択しました"+y+m+d,Toast.LENGTH_LONG).show()
                },
                year,month,day
            )
            dtp.show()
        }
    }
}