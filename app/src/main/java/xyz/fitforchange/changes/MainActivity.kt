package xyz.fitforchange.changes

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        //customize toolbar title
        toolbar.setTitleTextAppearance(baseContext, R.style.ToolBarTitle)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.pager)

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                when (position) {
                    0 -> return WoutListFragment.newInstance()
                    1 -> return CalendarFragment.newInstance()
                    2 -> return ClockFragment.newInstance()
                    3 -> return ScribbleFragment.newInstance()
                    4 -> return CheckInFragment.newInstance()
                }
                return WoutListFragment.newInstance()
            }

            override fun getItemCount(): Int {
                return 5
            }
        }

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                        when (position) {
                0 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.list_wout)
                1 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.calendar)
                2 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.clock)
                3 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.scribble)
                4 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.checkin)
            }
        }.attach()

    }

}
