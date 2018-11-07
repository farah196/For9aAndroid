package com.example.farahal_kiswani.for9a.opportunity

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils

class OpportunityItemViewModel (private val dataModel: OpportunityModel) : BaseObservable() {


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

    @Bindable
    fun getOrganization(): String {
        return if (!TextUtils.isEmpty(dataModel.getOrganization())) dataModel.getOrganization()!! else ""
    }

    @Bindable
    fun getView(): Int {
        return if (!TextUtils.isEmpty(dataModel.getView().toString())) dataModel.getView()!! else 0
    }

    @Bindable
    fun getImageOrganizationUrl(): String {
        return if (!TextUtils.isEmpty(dataModel.getImageOrganizationUrl())) dataModel.getImageOrganizationUrl()!! else ""
    }
}

