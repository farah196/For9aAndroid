package com.example.farahal_kiswani.for9a.signUp

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.app.FragmentManager

class SignUpViewModel(fragmentManger: FragmentManager) : BaseObservable() {

    private var adapter: TabPagerAdapter? = null


    init {
        adapter = TabPagerAdapter(fragmentManger)

    }

    @Bindable
    fun getAdapter(): TabPagerAdapter {
        return this.adapter!!
    }

}