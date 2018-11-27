package com.example.farahal_kiswani.for9a.opportunity

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageButton
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.ActivityOpportunityBinding
import kotlinx.android.synthetic.main.activity_opportunity.*

class OpportunityActivity : AppCompatActivity() {

    private var dataViewModel: OpportunityViewModel = OpportunityViewModel(this)
    var context: Context? = null
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
        val gridView = view.findViewById<ImageButton>(R.id.mGridIcon)
        val listView = view.findViewById<ImageButton>(R.id.mListIcon)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, true)

        gridView.setOnClickListener {

            recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2, GridLayoutManager.VERTICAL, true)
        }

        listView.setOnClickListener {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, true)
        }

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
        dataViewModel.drawer(this, drawer_layout, toolbar, navigation)
    }
}



