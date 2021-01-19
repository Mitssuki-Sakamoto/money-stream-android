package com.example.moneystream.presenters.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneystream.R
import com.example.moneystream.presenters.EventItems
import com.example.moneystream.presenters.views.EventAdapter
import com.example.moneystream.presenters.views.EventHolder
import com.example.moneystream.presenters.activities.EventActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventListFragment : BaseFragment(), EventHolder.ItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    private lateinit var manager: RecyclerView.LayoutManager

    private var listener: FragmentListener? = null

    interface FragmentListener {
        fun onClickFab()
        fun onClickListItem()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragment = inflater.inflate(R.layout.fragment_event_list, container, false)

        myAdapter = EventAdapter(this.context, this, EventItems())
        manager = LinearLayoutManager(this.context)
        recyclerView = fragment.findViewById<RecyclerView>(R.id.event_recycler).apply {
            setHasFixedSize(true)
            this.layoutManager = manager
            this.adapter = myAdapter
        }

        return fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is EventListFragment.FragmentListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(this.context, "click $position event", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, EventActivity::class.java)
        startActivity(intent)
    }

    companion object {
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