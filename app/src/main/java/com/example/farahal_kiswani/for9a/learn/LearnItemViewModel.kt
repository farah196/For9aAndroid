package com.example.farahal_kiswani.for9a.learn

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import com.example.farahal_kiswani.for9a.opportunity.OpportunityModel

class LearnItemViewModel (private val dataModel: LearnModel) : BaseObservable()  {
    @Bindable
    fun getTitle(): String {
        return if (!TextUtils.isEmpty(dataModel.getTitle())) dataModel.getTitle()!! else ""
    }


    @Bindable
    fun getType(): String {
        return if (!TextUtils.isEmpty(dataModel.getType())) dataModel.getType()!! else ""
    }

    @Bindable
    fun getImageUrl(): String {
        return if (!TextUtils.isEmpty(dataModel.getImageUrl())) dataModel.getImageUrl()!! else ""
    }
}