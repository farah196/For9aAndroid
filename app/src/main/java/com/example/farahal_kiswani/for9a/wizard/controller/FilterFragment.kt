package com.example.farahal_kiswani.for9a.wizard.controller

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.ActivityWizaredBinding
import com.example.farahal_kiswani.for9a.databinding.FilterFragmentBinding
import com.example.farahal_kiswani.for9a.databinding.FragmentFinalBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.FilterCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterViewModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.FinalViewModel

class FilterFragment :BaseWizaredFragment(){
    lateinit var filterViewModel:FilterViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FilterFragmentBinding = DataBindingUtil.inflate(
            inflater,
        R.layout.filter_fragment, container, false
        )
        filterViewModel = FilterViewModel()
        binding.viewFilter = filterViewModel

   //     binding.mRecyclerFilter .layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, true)

        return binding.getRoot()

    }



}