package com.example.farahal_kiswani.for9a.wizard.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import java.util.ArrayList

class ViewPagerAdapter(fm: FragmentManager, mFragments: ArrayList<BaseWizaredFragment>) : FragmentPagerAdapter(fm) {
     var mFragments: ArrayList<BaseWizaredFragment>?= mFragments

    override fun getItem(i: Int): Fragment
    {
        return mFragments!![i]
    }

    override fun getCount(): Int
    {
        return mFragments!!.size
    }
}

