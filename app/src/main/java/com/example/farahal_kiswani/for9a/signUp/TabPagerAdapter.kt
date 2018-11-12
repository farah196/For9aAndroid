package com.example.farahal_kiswani.for9a.signUp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPagerAdapter (fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    //returns the Fragments to be loaded inside the ViewPager
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Fragment1.getInstance()
            }
            1 -> {
                Fragment2.getInstance()

            }
            2 -> {
                Fragment3.getInstance()

            }
            else ->
                Fragment1.getInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "one"
            1 -> return "two"
            2-> return " three"

        }
        return null
    }


}