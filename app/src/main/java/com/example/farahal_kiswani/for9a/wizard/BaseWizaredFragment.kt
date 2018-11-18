package com.example.farahal_kiswani.for9a.wizard

import android.support.v4.app.Fragment

 open class BaseWizaredFragment : Fragment() {

    var mCallback: WizaredPagerCallback? = null

    fun setCallback(mCallback: WizaredPagerCallback) {
        this.mCallback = mCallback
    }


}