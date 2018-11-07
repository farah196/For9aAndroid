package com.example.farahal_kiswani.for9a.learn

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.ActivityLearnBinding
import com.example.farahal_kiswani.for9a.databinding.ActivityOpportunityBinding
import com.example.farahal_kiswani.for9a.opportunity.OpportunityViewModel
import kotlinx.android.synthetic.main.activity_opportunity.*

class LearnActivity : AppCompatActivity() {
    private var ViewModel: LearnViewModel = LearnViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = bind()
        initRecyclerView(view)

    }


    override fun onResume() {
        super.onResume()
        ViewModel.setUp()
    }


    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivityLearnBinding>(this, R.layout.activity_learn)
        binding.viewListLearn = ViewModel
        return binding.getRoot()
    }

    private fun initRecyclerView(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        val recyclerView = view.findViewById<RecyclerView>(R.id.mArticleRecycler)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, true)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL))

    }

}
