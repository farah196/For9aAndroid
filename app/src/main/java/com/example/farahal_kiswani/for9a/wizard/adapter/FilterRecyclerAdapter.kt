package com.example.farahal_kiswani.for9a.wizard.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FilterRowBinding
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterItemViewModel

class FilterRecyclerAdapter : RecyclerView.Adapter<FilterRecyclerAdapter.FilterViewHolder>() {

    private val data: MutableList<FilterModel>


    init {
        this.data = ArrayList<FilterModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.filter_row,
            FrameLayout(parent.context), false
        )
        return FilterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val dataModel = data[position]
        holder.setViewModel(FilterItemViewModel(dataModel))
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    override fun onViewAttachedToWindow(holder: FilterViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: FilterViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(data: List<FilterModel>?) {
        if (data == null || data.isEmpty()) {
            this.data.clear()
        } else {
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: FilterRowBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<FilterRowBinding>(itemView)
            }
        }

        fun unbind() {
            if (binding != null) {
                binding!!.unbind()
            }
        }

        fun setViewModel(viewModel: FilterItemViewModel) {
            if (binding != null) {
                binding!!.viewRowFilter = viewModel
            }
        }
    }
}
