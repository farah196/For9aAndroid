package com.example.farahal_kiswani.for9a.wizard.controller

import android.databinding.DataBindingUtil
import android.os.Bundle


import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.for9a.R

import com.example.farahal_kiswani.for9a.databinding.ActivityWizaredBinding
import com.example.farahal_kiswani.for9a.wizard.adapter.ViewPagerAdapter
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.util.CustomViewPager
import com.example.farahal_kiswani.for9a.wizard.viewModel.WizaredViewModel

import java.util.ArrayList

class WizaredActivity : AppCompatActivity(), WizaredPagerCallback {

    lateinit var viewPager: CustomViewPager
    var wizaredViewModel: WizaredViewModel =
        WizaredViewModel(supportFragmentManager)
    var mFragments = ArrayList<BaseWizaredFragment>()
    var currentFragmentPosition = 0
    var mAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: View = bind()
        initViewPager(view)
    }


    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivityWizaredBinding>(this, R.layout.activity_wizared)
        binding.viewWizared = wizaredViewModel
        return binding.getRoot()

    }


    private fun initViewPager(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        viewPager = view.findViewById<CustomViewPager>(R.id.viewpager)

        viewPager.setPagingEnabled(false)

        var mFragment: BaseWizaredFragment =
            InterestFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)


        mFragment = SignUpFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)

        mFragment = FinalFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)


        mAdapter = ViewPagerAdapter(supportFragmentManager, mFragments)
        viewPager.adapter = mAdapter


    }


    override fun onFinish() {
        wizaredViewModel.OpenMainActivity(this)
    }

    override fun onNext() {
        if (currentFragmentPosition < mFragments.size - 1) {
            currentFragmentPosition++

            viewPager.currentItem = currentFragmentPosition
        } else {
            onFinish()
        }
    }
}