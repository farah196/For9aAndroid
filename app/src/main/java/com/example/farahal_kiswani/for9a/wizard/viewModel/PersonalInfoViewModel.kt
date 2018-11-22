package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.interfaces.PersonalInfoFragmentCallback


class PersonalInfoViewModel(val interestCallback: PersonalInfoFragmentCallback) : BaseObservable() {
    val mGender=ObservableField<String>("")
    val mBirthday=ObservableField<String>("")
    val mResidence=ObservableField<String>("")
    val mPhone=ObservableField<String>("")
    val mEducationalLevel=ObservableField<String>("")
    val mSpecialization=ObservableField<String>("")


    fun onLoginButtonClicked(view:View){
        interestCallback.onLoginClicked(mBirthday.get()!!,mResidence.get()!!,mPhone.get()!!,mEducationalLevel.get()!!,mSpecialization.get()!!)

    }

    fun onLoginFailed(message:String){

    }

}