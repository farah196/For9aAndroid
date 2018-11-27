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
import com.example.farahal_kiswani.for9a.wizard.model.CountriesModel
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.model.IdTitleModel
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterViewModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.FinalViewModel

class FilterFragment :BaseWizaredFragment(),FilterCallback{


    lateinit var filterViewModel:FilterViewModel
    lateinit var mModel: FilterModel
    lateinit var countriesModel: CountriesModel
    lateinit var IdTitleModel: IdTitleModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FilterFragmentBinding = DataBindingUtil.inflate(
            inflater,
        R.layout.filter_fragment, container, false
        )
        filterViewModel = FilterViewModel()
        binding.viewFilter = filterViewModel

      binding.mRecyclerFilter .layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, true)


        when(fragmentType)
        {
            WizaredActivity.DataTypes.Categories-> this.mModel=IdTitleModel
            WizaredActivity.DataTypes.Interests->  this.mModel=IdTitleModel
            WizaredActivity.DataTypes.Countries-> this. mModel=countriesModel
            else -> {
                this.mModel=    IdTitleModel
            }

    }
        return binding.getRoot()

    }



    fun setFilterData(data:ArrayList<FilterModel>){

    }




    override fun getData(mData: ArrayList<FilterModel>) {
        val item:FilterModel= FilterModel(fragmentType)
        if(item.isSelect()){
            if(fragmentType== WizaredActivity.DataTypes.Countries){
                mCallback!!.onNext(setFilterData(),WizaredActivity.DataTypes.Countries)

            }
            if(fragmentType== WizaredActivity.DataTypes.Categories){
                mCallback!!.onNext(setFilterData(),WizaredActivity.DataTypes.Categories)

            }

            if(fragmentType== WizaredActivity.DataTypes.Interests){
                mCallback!!.onNext(setFilterData(),WizaredActivity.DataTypes.Interests)

            }
        }
    }

}