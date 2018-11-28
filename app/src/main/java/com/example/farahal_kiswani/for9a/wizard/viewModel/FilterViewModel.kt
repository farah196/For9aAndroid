package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import android.databinding.ObservableInt
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.adapter.FilterRecyclerAdapter
import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity
import com.example.farahal_kiswani.for9a.wizard.interfaces.FilterCallback
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel


class FilterViewModel(val filterData: ArrayList<FilterModel>, val filterCallback: FilterCallback) : BaseObservable(),
    View.OnClickListener {


    var filterAdapter: FilterRecyclerAdapter
    private var data: MutableList<FilterModel>? = null
    lateinit var mCallback: View.OnClickListener


    init {
        data = filterData
        filterAdapter = FilterRecyclerAdapter()
        filterAdapter.mCallback = this
        filterAdapter.updateData(data)

    }

    override fun onClick(v: View?) {
        mCallback.onClick(v)
    }


    @Bindable
    fun getData(): List<FilterModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): FilterRecyclerAdapter {
        return this.filterAdapter
    }

    fun saveData(view: View) {
        filterCallback.saveData(filterData)
    }
}