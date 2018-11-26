package com.example.farahal_kiswani.for9a.wizard.controller

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FilterFragmentBinding
import com.example.farahal_kiswani.for9a.databinding.FragmentFinalBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.FilterCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterViewModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.FinalViewModel

class FilterFragment :BaseWizaredFragment(),FilterCallback{
    lateinit var filterViewModel:FilterViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FilterFragmentBinding = DataBindingUtil.inflate(
            inflater,
        R.layout.filter_fragment, container, false
        )
        filterViewModel = FilterViewModel()
        binding.viewFilter = filterViewModel


        when(fragmentType){

            WizaredActivity.DataTypes.Categories -> TODO()
            WizaredActivity.DataTypes.Countries -> TODO()
            WizaredActivity.DataTypes.Interests -> this.mModel = InterestsFilterModel(fragmentType)
        }

        return binding.getRoot()

    }

    override fun getFilter() {
     //  mCallback.onNext(,)
    }


    fun setFilterData(data:ArrayList<FilterItem>){

    }
}