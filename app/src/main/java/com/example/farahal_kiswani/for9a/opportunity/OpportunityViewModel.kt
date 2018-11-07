package com.example.farahal_kiswani.for9a.opportunity
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.example.farahal_kiswani.for9a.filter.CategoryAdapter
import com.example.farahal_kiswani.for9a.filter.FilterModel
import java.util.ArrayList
import android.databinding.ObservableInt

class OpportunityViewModel : BaseObservable() {
    private var adapter: OpportunityAdapter? = null
    private var data: MutableList<OpportunityModel>? = null
    private var category: CategoryAdapter? = null
    private var filter: MutableList<FilterModel>? = null
    private var isLoading: Boolean = false
    var scrollTo = ObservableInt()
    init {
        data = ArrayList<OpportunityModel>()
        adapter = OpportunityAdapter()
        category = CategoryAdapter()
        filter = ArrayList<FilterModel>()
    }

    fun setUp() {
        fetchData()

    }

    fun setUpFilter() {
        fetchFilter()
    }


    fun setUpLoadMore() {
        setLoading(true)
        scrollTo.set(5)
        fetchData()

    }
    @Bindable
    fun getFilter(): List<FilterModel> {
        return this.filter!!
    }

    @Bindable
    fun getCategory(): CategoryAdapter {
        return this.category!!
    }

    @Bindable
    fun getData(): List<OpportunityModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): OpportunityAdapter {
        return this.adapter!!
    }

    private fun fetchData() {
        val titles: ArrayList<String> = ArrayList()
        titles.add("تبادل ثقافي")
        titles.add("فرص عمل")
        titles.add("فرص تعليم")
        titles.add("منحة مالية")
        titles.add("منحة دراسية")
        titles.add("جوائز ومسابقات")
        titles.add("فرص إقامة")
        titles.add(" دورات عبر الإنترنت")
        for (i in 0 until titles.size) {
            val dataModel = OpportunityModel()
            dataModel.setTitle(titles[i])

            data!!.add(dataModel)
        }

        notifyPropertyChanged(BR.data)

    }

    private fun fetchFilter() {

        val titles: ArrayList<String> = ArrayList()
        titles.add("تبادل ثقافي")
        titles.add("فرص عمل")
        titles.add("فرص تعليم")
        titles.add("منحة مالية")
        titles.add("منحة دراسية")
        titles.add("جوائز ومسابقات")
        titles.add("فرص إقامة")
        titles.add(" دورات عبر الإنترنت")
        for (i in 0 until titles.size) {
            val dataModel = FilterModel()
            dataModel.setName(titles[i])

            filter!!.add(dataModel)
        }

        notifyPropertyChanged(BR.filter)
    }

    @Bindable
    fun isLoading(): Boolean {
        return isLoading
    }

    fun setLoading(loading: Boolean) {
        isLoading = loading
        notifyPropertyChanged(BR._all)
    }
}