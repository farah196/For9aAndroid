package com.example.farahal_kiswani.for9a.filter

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils

class CategoryItemViewModel (private val dataModel: FilterModel) : BaseObservable() {


    @Bindable
    fun getName(): String {
        return if (!TextUtils.isEmpty(dataModel.getName())) dataModel.getName() else ""
    }

}