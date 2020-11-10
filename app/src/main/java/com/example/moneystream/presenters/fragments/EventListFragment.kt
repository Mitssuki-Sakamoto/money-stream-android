package com.example.moneystream.presenters.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.moneystream.R
import com.example.moneystream.presenters.activities.CreateEventActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.RuntimeException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventListFragment : BaseFragment() {
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
        val fragment = inflater.inflate(R.layout.fragment_event_list, container, false)

        val listView = fragment.findViewById(R.id.event_list_listView) as ListView
        val dataArray = arrayListOf<String>("熱海", "沖縄", "北海道")
        val adapter = this.context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, dataArray) }
        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val text = (view.findViewById<TextView>(android.R.id.text1)).text
            Toast.makeText(activity, "Clicked: ${text}", Toast.LENGTH_SHORT).show()

        }

        val fab = fragment.findViewById(R.id.event_list_fab) as FloatingActionButton
        fab.setOnClickListener { view: View? ->
            Toast.makeText(activity, "Clicked: fab", Toast.LENGTH_SHORT).show()
        }

        return fragment
    }
    
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}