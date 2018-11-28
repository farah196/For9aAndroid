package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import com.android.databinding.library.baseAdapters.BR
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel

class FilterItemViewModel(private val dataModel: FilterModel) :BaseObservable(){
      var checked: Boolean = false

    @Bindable
    fun getTitle(): String
    {
        return if (!TextUtils.isEmpty(dataModel.getText())) dataModel.getText() else ""
    }




    @Bindable
    fun getChecked(): Boolean? {
        return this.checked
    }

    fun setChecked(checked: Boolean?) {
        this.checked = checked!!
   //   notifyPropertyChanged(BR.)
    }
}