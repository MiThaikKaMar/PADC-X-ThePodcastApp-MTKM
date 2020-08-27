package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments.CategoriesFragment
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments.PodcastFragment
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments.YourShowFragment

class NavigationAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return PodcastFragment()
            1 -> return CategoriesFragment()
            2 -> return YourShowFragment()
            3 -> return Fragment()
        }
        return PodcastFragment()
    }
}