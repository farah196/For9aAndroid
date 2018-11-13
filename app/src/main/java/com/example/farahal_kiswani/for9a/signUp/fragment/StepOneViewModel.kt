package com.example.farahal_kiswani.for9a.signUp.fragment


import android.app.PendingIntent.getActivity
import android.databinding.ObservableField
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.signUp.Fragment2
import com.example.farahal_kiswani.for9a.signUp.SignUpCallback

class StepOneViewModel(val fragmentManager: FragmentManager) :SignUpCallback {

    val email = ObservableField<String>("")

    override fun onNext(view:View) {
        val transaction = fragmentManager.beginTransaction()
        transaction .replace(R.id.mLayoutContainer,Fragment2()).addToBackStack(null).commit()
    }

    override fun onFinish() {

    }

    override fun onPrevious() {

    }



}