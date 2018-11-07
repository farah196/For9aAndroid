package com.example.farahal_kiswani.for9a.opportunity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.ActivityOpportunityBinding
import com.example.farahal_kiswani.for9a.learn.LearnActivity
import kotlinx.android.synthetic.main.activity_opportunity.*

class OpportunityActivity : AppCompatActivity() {
    private var dataViewModel: OpportunityViewModel = OpportunityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = bind()
        initRecyclerView(view)
        initCategoryFilter(view)
        initDrawer(view)

    }


    override fun onResume() {
        super.onResume()
        dataViewModel.setUp()
        dataViewModel.setUpFilter()
    }


    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivityOpportunityBinding>(this, R.layout.activity_opportunity)

        binding.viewListOpp = dataViewModel
        return binding.getRoot()
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.mNameRecycler)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, true)

        dataViewModel.setUpLoadMore()
//
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (!dataViewModel.isLoading() ) {
//                   dataViewModel.setUpLoadMore()
//                }
//            }
//        })

    }

    private fun initCategoryFilter(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.mFilterRecycler)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, true)


    }

    private fun initDrawer(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val mDrawerToggle: ActionBarDrawerToggle?
        mDrawerToggle = object :
            ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)

            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        drawer_layout!!.addDrawerListener(mDrawerToggle)
        mDrawerToggle.setDrawerIndicatorEnabled(true)

        mDrawerToggle.syncState()

        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mLearn -> {
                    val intent = Intent(this, LearnActivity::class.java)
                    startActivity(intent)
                }

            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }




}