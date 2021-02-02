package com.example.moneystream.presenters.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_edit_history.date
import kotlinx.android.synthetic.main.activity_edit_history.time
import java.util.Calendar

open class EditHistoryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_history)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val minute = calender.get(Calendar.MINUTE)

        date.setOnClickListener {// DatePicker
            val dtp = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                    date.setText("")
                    date.setText(getString(R.string.date_format).format(y, m+1, d))
                },
                year,month,day
            )
            dtp.show()
        }

        time.setOnClickListener {// TimePicker
            val tpd = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, h, m ->
                    time.setText("")
                    time.setText(getString(R.string.time_format).format(h, m))
                },
                hour,minute,true
            )
            tpd.show()
        }
    }
}