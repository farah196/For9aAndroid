package com.example.farahal_kiswani.for9a.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.farahal_kiswani.for9a.wizard.adapter.FilterRecyclerAdapter
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterRecyclerViewDataBinding {
    @BindingAdapter("app:adapter", "app:data")
    fun bind(recyclerView: RecyclerView, adapter: FilterRecyclerAdapter, data: List<FilterModel>) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }


}