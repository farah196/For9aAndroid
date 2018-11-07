package com.example.farahal_kiswani.for9a.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.farahal_kiswani.for9a.opportunity.OpportunityAdapter
import com.example.farahal_kiswani.for9a.opportunity.OpportunityModel

class OpportunityRecyclerViewDataBinding {
    @BindingAdapter("app:adapter", "app:data")
    fun bind(recyclerView: RecyclerView, adapter: OpportunityAdapter, data: List<OpportunityModel>) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }

    @BindingAdapter("app:scrollTo")
    fun scrollTo(recyclerView: RecyclerView, position: Int) {
        recyclerView.scrollToPosition(position)
    }
}