package com.example.farahal_kiswani.for9a.wizard.interfaces

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity

interface WizaredPagerCallback {

    fun onNext( ob: Any, dataType: WizaredActivity.DataTypes)
    fun onFinish()
    fun onBack()

}