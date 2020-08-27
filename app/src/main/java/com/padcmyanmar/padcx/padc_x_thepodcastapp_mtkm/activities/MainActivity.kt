package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.NavigationAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager2.adapter=NavigationAdapter(this)
        view_pager2.currentItem=0
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottom_navigation.selectedItemId=R.id.item_pod_cast
                    1->bottom_navigation.selectedItemId=R.id.item_categories
                    2->bottom_navigation.selectedItemId=R.id.item_your_shows
                    3->bottom_navigation.selectedItemId=R.id.item_profile
                }
            }
        })
        bottom_navigation.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when{
                    item.itemId==R.id.item_pod_cast->view_pager2.currentItem=0
                    item.itemId==R.id.item_categories->view_pager2.currentItem=1
                    item.itemId==R.id.item_your_shows->view_pager2.currentItem=2
                    item.itemId==R.id.item_profile->view_pager2.currentItem=3
                }
                return true
            }
        })
    }
}