package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.controller.SignUpFragmentCallback

class SignUpViewModel (val signUpCallback: SignUpFragmentCallback): BaseObservable() {

    val email = ObservableField<String>("")
    fun getEmail(view: View) {
      signUpCallback.onSignClicked(email = email.toString())
    }

}