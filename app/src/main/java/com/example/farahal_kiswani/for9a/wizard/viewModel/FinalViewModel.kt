package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View

import com.example.farahal_kiswani.for9a.wizard.interfaces.FinalCallback

class FinalViewModel(val call: FinalCallback) : BaseObservable() {


    val final = ObservableField<String>("")
    fun getFinal(view: View) {
        call.final()
        print("null")
    }
}