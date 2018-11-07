package com.example.farahal_kiswani.for9a.databinding
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.farahal_kiswani.for9a.filter.CategoryAdapter
import com.example.farahal_kiswani.for9a.filter.FilterModel

class CategoryFilterViewDataBinding {
    @BindingAdapter("app:adapter", "app:data")
    fun bind(recyclerView: RecyclerView, adapter: CategoryAdapter, data: List<FilterModel>) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }
}