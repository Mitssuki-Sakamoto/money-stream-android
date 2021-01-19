package com.example.moneystream.presenters.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneystream.R
import kotlinx.android.synthetic.main.activity_edit_my_history.*
import kotlinx.android.synthetic.main.fragment_budget_form.*
import kotlinx.android.synthetic.main.fragment_budget_form.date
import kotlinx.android.synthetic.main.fragment_event_form.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFormFragment : BaseFormFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_form, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH) + 1
        val day = calender.get(Calendar.DAY_OF_MONTH)
        //date.setText("%s-%s-%s".format(year, month, day))

        start_date.setOnClickListener {
            val dtp = DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                    start_date.setText("")
                    start_date.setText("%s-%s-%s".format(y, m+1, d))
                    //Toast.makeText(context!!, "日付を選択しました"+y+m+d,Toast.LENGTH_LONG).show()
                },
                year,month,day
            )
            dtp.show()
        }
        end_date.setOnClickListener {
            val dtp = DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                    end_date.setText("")
                    end_date.setText("%s-%s-%s".format(y, m+1, d))
                    //Toast.makeText(context!!, "日付を選択しました"+y+m+d,Toast.LENGTH_LONG).show()
                },
                year,month,day
            )
            dtp.show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventFormFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventFormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}