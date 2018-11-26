package com.example.farahal_kiswani.for9a.filter

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FilterRecyclerRowBinding
import java.util.ArrayList

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val filterMain: MutableList<FilterMainModel>

    init
    {
        this.filterMain = ArrayList<FilterMainModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.filter_main_recycler_row,
            FrameLayout(parent.context), false
        )
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dataModel = filterMain[position]
        holder.setViewModel(CategoryItemViewModel(dataModel))
        when (position) {
            0 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#827f93"))

            }
            1 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#c467f4"))

            }
            2 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#3b9aee"))
            }
            3 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#9bc53d"))
            }
            4 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#f4a261"))
            }
            5 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#1ed2bb"))
            }
            6 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#778da9"))
            }
            7 -> {
                holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#20bf55"))
            }


            else -> holder.binding!!.mCardFilter.setCardBackgroundColor(Color.parseColor("#9f9fed"))

        }
    }

    override fun getItemCount(): Int {
        return this.filterMain.size
    }

    override fun onViewAttachedToWindow(holder: CategoryViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: CategoryViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(filterMain: List<FilterMainModel>?) {
        if (filterMain == null || filterMain.isEmpty()) {
            this.filterMain.clear()
        } else {
            this.filterMain.addAll(filterMain)
        }
        notifyDataSetChanged()
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: FilterRecyclerRowBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<FilterRecyclerRowBinding>(itemView)
            }
        }

        fun unbind() {
            if (binding != null) {
                binding!!.unbind() // Don't forget to unbind
            }
        }

        fun setViewModel(viewModel: CategoryItemViewModel) {
            if (binding != null) {
                binding!!.viewRowFilter = viewModel

            }
        }
    }
}

