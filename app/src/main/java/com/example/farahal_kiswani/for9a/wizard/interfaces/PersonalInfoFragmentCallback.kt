package com.example.farahal_kiswani.for9a.wizard.interfaces

import android.content.Context
import android.support.v4.app.FragmentManager

interface PersonalInfoFragmentCallback {
    fun onLoginClicked(mGender:String,mBirthday:String,mResidence:String,mPhone:String,mEducationalLevel:String,mSpecialization:String)
    fun onBack ()
    fun getContext ():Context
}