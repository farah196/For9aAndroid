package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.farahal_kiswani.for9a.wizard.adapter.FilterRecyclerAdapter
import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterViewModel: BaseObservable() {
    private var adapter: FilterRecyclerAdapter? = null
    private var data: MutableList<FilterModel>? = null

    init {
        data = ArrayList<FilterModel>() as MutableList<FilterModel>?
        adapter = FilterRecyclerAdapter()

    }
    @Bindable
    fun getData(): List<FilterModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): FilterRecyclerAdapter {
        return this.adapter!!
    }

    fun fetchCountryData ()
    {
        val dataModel = FilterModel(WizaredActivity.DataTypes.Countries)
        dataModel.countriesModel.name= "bla"
    }

}