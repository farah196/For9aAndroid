package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.controller.InterestFragmentCallback


class InterestViewModel(val interestCallback: InterestFragmentCallback) : BaseObservable() {
    val name = ObservableField<String>("")

    fun onLoginButtonClicked(view:View){
        interestCallback.onLoginClicked(name.get()!!)
    }

    fun onLoginFailed(message:String){

    }

}