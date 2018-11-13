package com.example.farahal_kiswani.for9a.signUp

import android.support.v4.app.Fragment
import android.view.View

interface SignUpCallback{

    fun onNext (view:View)
    fun onFinish()
    fun onPrevious()
//    fun getState(stateDto : k)
}