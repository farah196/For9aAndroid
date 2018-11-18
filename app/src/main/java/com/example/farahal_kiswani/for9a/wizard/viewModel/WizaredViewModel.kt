package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import com.example.farahal_kiswani.for9a.opportunity.OpportunityActivity
import com.example.farahal_kiswani.for9a.wizard.adapter.ViewPagerAdapter
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import java.util.ArrayList

class WizaredViewModel (fragmentManger: FragmentManager) : BaseObservable() {
    var mFragments = ArrayList<BaseWizaredFragment>()
    private var adapter: ViewPagerAdapter? = null


    init
    {

        adapter = ViewPagerAdapter(fragmentManger, mFragments)

    }

    @Bindable
    fun getAdapter(): ViewPagerAdapter {
        return this.adapter!!
    }

    fun OpenMainActivity(mContext: Context) {
        val intent = Intent(mContext, OpportunityActivity::class.java)
        ContextCompat.startActivity(mContext, intent, Bundle())
    }
}