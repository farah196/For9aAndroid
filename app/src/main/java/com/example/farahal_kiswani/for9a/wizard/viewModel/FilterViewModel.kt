package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.adapter.FilterRecyclerAdapter
import com.example.farahal_kiswani.for9a.wizard.interfaces.FilterCallback
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterViewModel(val call: FilterCallback): BaseObservable() {
    private var adapter: FilterRecyclerAdapter? = null
    private var data: MutableList<FilterModel>? = null
    var mList : ArrayList<FilterModel> = ArrayList<FilterModel>()

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

//    fun getData(view: View)
//    {
//        call.getData(mList)
//    }
}