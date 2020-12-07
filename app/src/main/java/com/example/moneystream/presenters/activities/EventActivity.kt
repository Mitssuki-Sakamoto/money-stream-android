package com.example.moneystream.presenters.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.*
import androidx.viewpager.widget.ViewPager
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BaseFragment
import com.example.moneystream.presenters.fragments.EventHomeFragment
import com.example.moneystream.presenters.fragments.EventListFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_event.*

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3,
    R.string.tab_text_4
)

class EventActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val toolbar_myaccount: ImageView = findViewById(R.id.toolbar_image_myaccount)
        toolbar_myaccount.setOnClickListener { view ->
            onClickToolBar(view)
        }

        val toolbar_detail: ImageView = findViewById(R.id.toolbar_image_detail)
        toolbar_detail.setOnClickListener { view ->
            onClickToolBar(view)
        }

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
    private fun onClickToolBar(view: View) {
        when(view.id) {
            R.id.toolbar_image_myaccount -> {
                Toast.makeText(this, "Clicked: MyAccount", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MyAccountActivity::class.java)
                startActivity(intent)
            }
            R.id.toolbar_image_detail -> {
                Toast.makeText(this, "Clicked: Detail", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, EventDetailActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 4
    }

}

class PlaceholderFragment : BaseFragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}

class PageViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }
    fun setIndex(index: Int) {
        _index.value = index
    }
}


