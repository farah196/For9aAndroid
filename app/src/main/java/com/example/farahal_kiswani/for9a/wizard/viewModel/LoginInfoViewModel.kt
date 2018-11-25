package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.farahal_kiswani.for9a.wizard.interfaces.LoginInfoFragmentCallback


class LoginInfoViewModel (val loginInfoCallback: LoginInfoFragmentCallback): BaseObservable() {

    val firstname = ObservableField<String>("")
    val lastname = ObservableField<String>("")
    val email = ObservableField<String>("")
    val password = ObservableField<String>("")

    fun login(view: View) {
        loginInfoCallback.onSignClicked(firstname.get()!!, lastname.get()!!, email.get()!!, password.get()!!)
    }



}