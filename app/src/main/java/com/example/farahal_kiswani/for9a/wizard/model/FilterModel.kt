package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity

open class FilterModel(var mTitle:String,var selected: Boolean,var mId: String,dataTypes: WizaredActivity.DataTypes) {




    fun setText(text: String) {
        this.mTitle = text
    }

    fun setSelect(select: Boolean) {
        this.selected = select
    }

    fun setID(id: String) {
        this.mId = id
    }

    fun getText():String {
        return  mTitle
    }

    fun isSelect():Boolean {
        return selected
    }

    fun getID():String {
        return mId
    }

}