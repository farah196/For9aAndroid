package com.example.farahal_kiswani.for9a.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.farahal_kiswani.for9a.learn.LearnAdapter
import com.example.farahal_kiswani.for9a.learn.LearnModel

class LearnRecyclerViewDataBinding {
    @BindingAdapter("app:adapter", "app:data")
    fun bind(recyclerView: RecyclerView, adapter: LearnAdapter, data: List<LearnModel>) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }
}