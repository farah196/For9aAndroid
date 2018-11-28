package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity

open class FilterModel(val dataTypes: WizaredActivity.DataTypes) {


    lateinit var mTitle:String
    var checked: Boolean = false
    lateinit var mId: String

    fun setText(text: String) {
        this.mTitle = text
    }

    fun setSelect(select: Boolean) {
        this.checked = select

    }

    fun setID(id: String) {
        this.mId = id
    }

    fun getText():String {
        return  mTitle
    }

    fun isSelect():Boolean {
        return checked
    }

    fun getID():String {
        return mId
    }

    fun getType():WizaredActivity.DataTypes{
        return dataTypes;
    }

}