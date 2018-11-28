package com.example.farahal_kiswani.for9a.wizard.controller

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.CategoryFilterViewDataBinding
import com.example.farahal_kiswani.for9a.databinding.FilterFragmentBinding
import com.example.farahal_kiswani.for9a.wizard.adapter.FilterRecyclerAdapter
import com.example.farahal_kiswani.for9a.wizard.interfaces.FilterCallback
import com.example.farahal_kiswani.for9a.wizard.model.CountryModel
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.model.IdTitleModel
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterViewModel
import kotlinx.android.synthetic.main.filter_fragment.*

class FilterFragment : BaseWizaredFragment(), View.OnClickListener, FilterCallback {


    lateinit var filterViewModel: FilterViewModel
    lateinit var filterList: ArrayList<FilterModel>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FilterFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.filter_fragment, container, false
        )
        filterViewModel = FilterViewModel(filterList,this)
        filterViewModel.mCallback = this
        binding.mRecyclerFilter.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, true)
        filterViewModel.filterAdapter.mCallback = this
        filterViewModel.filterAdapter.updateData(filterList)
        binding.viewFilter = filterViewModel

        return binding.getRoot()

    }


    override fun onClick(v: View?) {
        val position: Int = mRecyclerFilter.getChildAdapterPosition(v!!)
        val mItem: FilterModel = filterViewModel.filterAdapter.data.get(position)
        mItem.setSelect(!mItem.isSelect())
        filterViewModel.filterAdapter.data.set(position, mItem)
        filterViewModel.filterAdapter.notifyItemChanged(position)
    }

    fun setData(mData: ArrayList<FilterModel>) {
        this.filterList = mData

    }


    override fun saveData(mData: ArrayList<FilterModel>) {
        val item: FilterModel = mData.get(0)

        when (item.getType()) {

            WizaredActivity.DataTypes.Countries -> mCallback.onNext(
                createSelectedCountriesList(mData),
                WizaredActivity.DataTypes.Countries
            )
            WizaredActivity.DataTypes.Categories -> mCallback.onNext(
                createIdTitleList(mData),
                WizaredActivity.DataTypes.Categories
            )
            WizaredActivity.DataTypes.Interests -> mCallback.onNext(
                createIdTitleList(mData),
                WizaredActivity.DataTypes.Interests
            )
        }



        if (item.isSelect()) {
            if (fragmentType == WizaredActivity.DataTypes.Countries) {
                item.getText()


            }
            if (fragmentType == WizaredActivity.DataTypes.Categories) {
                mCallback.onNext(mData, WizaredActivity.DataTypes.Categories)

            }

            if (fragmentType == WizaredActivity.DataTypes.Interests) {
                mCallback.onNext(mData, WizaredActivity.DataTypes.Interests)

            }
        }
    }

    private fun createIdTitleList(mData: ArrayList<FilterModel>): ArrayList<IdTitleModel> {
        val idTitleList: ArrayList<IdTitleModel> = ArrayList()
        for (item in mData) {
            if (item.isSelect()) {
                val idTitleItem: IdTitleModel = IdTitleModel(Integer.valueOf(item.getID()), item.getText())
                idTitleList.add(idTitleItem)
            }
        }
        return idTitleList
    }


    fun createSelectedCountriesList(mData: ArrayList<FilterModel>): ArrayList<CountryModel> {
        var countries: ArrayList<CountryModel> = ArrayList()
        for (item in mData) {
            if (item.isSelect()) {
                val country: CountryModel = CountryModel(item.getText(), item.getID())
                countries.add(country)
            }
        }
        return countries
    }

}