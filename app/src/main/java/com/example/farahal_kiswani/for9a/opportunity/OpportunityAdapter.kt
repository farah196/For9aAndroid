package com.example.farahal_kiswani.for9a.opportunity

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.OpportunityRowBinding
import java.util.ArrayList

class OpportunityAdapter : RecyclerView.Adapter<OpportunityAdapter.OpportunityViewHolder>() {

    private val data: MutableList<OpportunityModel>

    init
    {
        this.data = ArrayList<OpportunityModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpportunityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.opportunity_row,
            FrameLayout(parent.context), false
        )
        return OpportunityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OpportunityViewHolder, position: Int) {
        val dataModel = data[position]
        holder.setViewModel(OpportunityItemViewModel(dataModel))
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    override fun onViewAttachedToWindow(holder: OpportunityViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: OpportunityViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(data: List<OpportunityModel>?) {
        if (data == null || data.isEmpty()) {
            this.data.clear()
        } else {
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    class OpportunityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: OpportunityRowBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<OpportunityRowBinding>(itemView)
            }
        }

        fun unbind() {
            if (binding != null) {
                binding!!.unbind() // Don't forget to unbind
            }
        }

        fun setViewModel(viewModel: OpportunityItemViewModel) {
            if (binding != null) {
                binding!!.viewRowOpp = viewModel
            }
        }
    }
}
