package com.example.farahal_kiswani.for9a.learn

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.LearnRowBinding
import java.util.ArrayList

class LearnAdapter: RecyclerView.Adapter<LearnAdapter.LearnViewHolder>() {
    private val data: MutableList<LearnModel>

    init
    {
        this.data = ArrayList<LearnModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.learn_row,
            FrameLayout(parent.context), false
        )
        return LearnViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        val dataModel = data[position]
        holder.setViewModel(LearnItemViewModel(dataModel))
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    override fun onViewAttachedToWindow(holder: LearnViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: LearnViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(data: List<LearnModel>?) {
        if (data == null || data.isEmpty()) {
            this.data.clear()
        } else {
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    class LearnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding:LearnRowBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<LearnRowBinding>(itemView)
            }
        }

        fun unbind() {
            if (binding != null) {
                binding!!.unbind() // Don't forget to unbind
            }
        }

        fun setViewModel(viewModel: LearnItemViewModel) {
            if (binding != null) {
                binding!!.viewRowLearn = viewModel
            }
        }
    }
}