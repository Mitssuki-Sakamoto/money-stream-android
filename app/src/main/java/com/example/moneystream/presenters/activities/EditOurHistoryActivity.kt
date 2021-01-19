package com.example.moneystream.presenters.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_edit_my_history.*
import kotlinx.android.synthetic.main.fragment_budget_form.*
import kotlinx.android.synthetic.main.fragment_budget_form.date
import java.util.*

class EditOurHistoryActivity : EditHistoryActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_our_history)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val minute = calender.get(Calendar.MINUTE)
        //date.setText("%s-%s-%s".format(year, month, day))
        //time.setText("%s:%s".format(hour, minute))

        date.setOnClickListener {// DatePicker
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

        time.setOnClickListener {// TimePicker
            val tpd = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, h, m ->
                    time.setText("")
                    time.setText("%s:%s".format(h, m))
                },
                hour,minute,true
            )
            tpd.show()
        }
    }
}