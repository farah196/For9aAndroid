package com.example.farahal_kiswani.for9a.wizard.util

import android.support.v4.app.Fragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback

open class BaseWizaredFragment : Fragment() {

    var mCallback: WizaredPagerCallback? = null

    fun setCallback(mCallback: WizaredPagerCallback) {
        this.mCallback = mCallback
    }


}