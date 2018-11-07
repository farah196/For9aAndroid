package com.example.farahal_kiswani.for9a

import android.app.Application
import android.databinding.DataBindingUtil
import com.example.farahal_kiswani.for9a.databinding.AppDataBindingComponent


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(AppDataBindingComponent())
    }
}
