package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterItemViewModel(private val dataModel: FilterModel) :BaseObservable(){

    @Bindable
    fun getTitle(): String
    {
        return if (!TextUtils.isEmpty(dataModel.IdTitleModel.getTitle())) dataModel.IdTitleModel.getTitle()!! else ""
    }


//    @Bindable
//    fun getChecked(): String
//    {
//        return if (!TextUtils.isEmpty(dataModel.IdTitleModel.isChecked())) dataModel.IdTitleModel.isChecked()!! else ""
//    }
//

}