package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity

open class FilterModel(dataTypes: WizaredActivity.DataTypes) {


    lateinit var mTitle: String
    var selected: Boolean = false
    lateinit var mId: String

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