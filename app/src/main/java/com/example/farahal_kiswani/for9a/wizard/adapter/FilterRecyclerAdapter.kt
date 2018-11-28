package com.example.farahal_kiswani.for9a.wizard.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RadioGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FilterRowBinding
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterItemViewModel
import net.igenius.customcheckbox.CustomCheckBox

class FilterRecyclerAdapter : RecyclerView.Adapter<FilterRecyclerAdapter.FilterViewHolder>(), View.OnClickListener {



    public val data: MutableList<FilterModel>
    lateinit var mCallback:View.OnClickListener

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
        holder.bind(this)
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

    override fun onClick(v: View?) {

    }




    class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: FilterRowBinding? = null


        fun bind(listener:View.OnClickListener) {
            if (binding == null) {
                binding = DataBindingUtil.bind<FilterRowBinding>(itemView)
                itemView.setOnClickListener(listener)
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
