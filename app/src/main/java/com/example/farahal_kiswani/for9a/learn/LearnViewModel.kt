package com.example.farahal_kiswani.for9a.learn

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.example.farahal_kiswani.for9a.opportunity.OpportunityAdapter
import com.example.farahal_kiswani.for9a.opportunity.OpportunityModel
import java.util.ArrayList

class LearnViewModel : BaseObservable() {
    private var adapter : LearnAdapter? = null
    private var data: MutableList<LearnModel>? = null

    init {
        data = ArrayList<LearnModel>()
        adapter = LearnAdapter()
    }

    fun setUp() {
        fetchData()
    }


    @Bindable
    fun getData(): List<LearnModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): LearnAdapter {
        return this.adapter!!
    }

    private fun fetchData() {

        val titles:ArrayList<String> = ArrayList()
        titles.add("123213")
        titles.add("asdsad")
        titles.add("asdasd")
        titles.add("dsf")
        titles.add("sdf")
        for (i in 0 until titles.size) {
            val dataModel = LearnModel()
            dataModel.setTitle(titles.get(i))
            data!!.add(dataModel)
        }
        notifyPropertyChanged(BR.data)
    }



}