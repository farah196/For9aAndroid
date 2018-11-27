package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterItemViewModel(private val dataModel: FilterModel) :BaseObservable(){

    @Bindable
    fun getTitle(): String
    {
        return if (!TextUtils.isEmpty(dataModel.getText())) dataModel.getText() else ""
    }


    @Bindable
    fun getChecked(): String
    {
        return if (!TextUtils.isEmpty(dataModel.isSelect())) dataModel.isSelect() else ""
    }


}