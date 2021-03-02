package com.example.moneystream.presenters.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_input_bill.tiet_time
import kotlinx.android.synthetic.main.activity_input_bill.tiet_date
import java.util.*

class InputBillActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_bill)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val minute = calender.get(Calendar.MINUTE)
        tiet_date.setText(getString(R.string.date_format).format(year, month, day))
        tiet_time.setText(getString(R.string.time_format).format(hour, minute))

        tiet_date.setOnClickListener {// DatePicker
            val dtp = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                    tiet_date.setText("")
                    tiet_date.setText(getString(R.string.date_format).format(y, m+1, d))
                    //Toast.makeText(context!!, "日付を選択しました"+y+m+d,Toast.LENGTH_LONG).show()
                },
                year,month-1,day
            )
            dtp.show()
        }

        tiet_time.setOnClickListener {// TimePicker
            val tpd = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, h, m ->
                    tiet_time.setText("")
                    tiet_time.setText(getString(R.string.time_format).format(h, m))
                },
                hour,minute,true
            )
            tpd.show()
        }
    }
}