package com.example.farahal_kiswani.for9a.wizard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.app.FragmentManager
import java.util.ArrayList

class WizaredViewModel (fragmentManger: FragmentManager) : BaseObservable() {
    var mFragments = ArrayList<BaseWizaredFragment>()
    private var adapter: ViewPagerAdapter? = null

    init
    {

        adapter = ViewPagerAdapter(fragmentManger,mFragments)

    }

    @Bindable
    fun getAdapter(): ViewPagerAdapter {
        return this.adapter!!
    }
}