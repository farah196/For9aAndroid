package com.example.farahal_kiswani.for9a.wizard

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View

class SignUpViewModel( var mCallback: WizaredPagerCallback) : BaseObservable() {

    val email = ObservableField<String>("")
    fun getEmail(view: View) {
        mCallback.onNext()
    }

}