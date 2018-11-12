package com.example.farahal_kiswani.for9a.signUp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.farahal_kiswani.for9a.R
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_signup.*
import android.view.MotionEvent

class SignUpActivity : AppCompatActivity() {
    private val mContext = this


    private var mAdapter: TabPagerAdapter = TabPagerAdapter(supportFragmentManager)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setSupportActionBar(findViewById<View>(R.id.toolbar) as Toolbar)
        initActionBar()


        val mViewPager = findViewById<CustomViewPager>(R.id.viewpager)
        mViewPager.adapter = mAdapter
        mViewPager.offscreenPageLimit = 3
        mViewPager.setPagingEnabled(false)

//
//
//        viewpager_filter!!.setAdapter(mAdapter)
////        val selectionChanges =
////            SlideSelector.SelectionChanges {
////                    position, selectedItem -> tab.setSelectedIndex(position)
////            }
////        //   tab.setSelectedIndex(3) TODO (issue with selected item )
////        tab.setSelectionChanges(selectionChanges)
//
//        viewpager_filter.setCurrentItem(1)
//        viewpager_filter.isHorizontalScrollBarEnabled = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }


        }
        return super.onOptionsItemSelected(item)
    }






    private fun initActionBar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
}



