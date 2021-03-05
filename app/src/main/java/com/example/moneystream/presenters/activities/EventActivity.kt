package com.example.moneystream.presenters.activities

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.*
import androidx.viewpager.widget.ViewPager
import com.example.moneystream.R
import com.example.moneystream.presenters.fragments.BaseFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.my_toolbar.view.*
import kotlinx.android.synthetic.main.tab_layout.view.*

private val TAB_TITLES = arrayOf(
    R.string.tab_text1,
    R.string.tab_text2,
    R.string.tab_text3,
    R.string.tab_text4
    //R.string.tab_text5
)
private val TAB_ICONS = arrayOf(
    //TODO: Change icon later
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_home_black_18dp,
    R.drawable.ic_groups_black_24dp,
    R.drawable.ic_launcher_foreground
)

private const val TAB_MAIN = 2

class EventActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        toolbar_activity_event.pageTitle.text = getString(R.string.event_activity_title)

        val toolbarMyaccount: ImageView = findViewById(R.id.image_myaccount)
        toolbarMyaccount.setOnClickListener { view ->
            onClickToolBar(view)
        }

        val toolbarDetail: ImageView = findViewById(R.id.image_detail)
        toolbarDetail.setOnClickListener { view ->
            onClickToolBar(view)
        }

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.currentItem = TAB_MAIN

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        createTabLayout(tabs)
    }

    private fun onClickToolBar(view: View) {
        when(view.id) {
            R.id.image_myaccount -> {
                Toast.makeText(this, "Clicked: MyAccount", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MyAccountActivity::class.java)
                startActivity(intent)
            }
            R.id.image_detail -> {
                Toast.makeText(this, "Clicked: Detail", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, EventDetailActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun createTabLayout(tabs: TabLayout) {
        for (i in 0..TAB_TITLES.size) {
            //var tab = findViewById<View>(R.id.customTab).apply {
            //    this.findViewById<ImageView>(R.id.tabIcon).setImageResource(TAB_ICONS[i])
            //   this.findViewById<TextView>(R.id.tabText).setText(TAB_TITLES[i])
            //}
            //tabs.getTabAt(i)?.setCustomView(tab)
            tabs.getTabAt(i)?.setIcon(TAB_ICONS[i])
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
        return TAB_TITLES.size
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


// https://blog.codecamp.jp/android-app-tab