package com.example.moneystream.tabs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.moneystream.R

class RequestFragment : Fragment() {

    private var listView: ListView? = null

    companion object {
        fun newInstance() = RequestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val tmpnames = arrayListOf<String>("terui", "aikawa", "sakamoto")
        val view = inflater.inflate(R.layout.fragment_request, container, false)
        this.listView = view.findViewById(R.id.listViewRequest) as ListView
        val adapter = this.context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, tmpnames) }
        listView!!.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}