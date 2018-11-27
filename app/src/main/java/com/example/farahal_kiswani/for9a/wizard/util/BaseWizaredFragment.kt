package com.example.farahal_kiswani.for9a.wizard.util

import android.support.v4.app.Fragment
import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback

open class BaseWizaredFragment : Fragment() {

    var mCallback: WizaredPagerCallback? = null
    lateinit var fragmentType: WizaredActivity.DataTypes

    fun setCallback(mCallback: WizaredPagerCallback) {
        this.mCallback = mCallback
    }

    fun setType(fragmentType: WizaredActivity.DataTypes){
        this.fragmentType = fragmentType
    }


}