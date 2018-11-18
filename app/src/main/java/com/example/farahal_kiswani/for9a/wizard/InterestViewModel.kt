package com.example.farahal_kiswani.for9a.wizard

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View




class InterestViewModel ( var mCallback: WizaredPagerCallback): BaseObservable(),DataCallback {
    val name = ObservableField<String>("")
    val callback: WizaredPagerCallback? = null

    override fun setData(data: String) {
     name.set(data)
    }


    fun getName(view: View) {
        mCallback.onNext()
        print("null")
    }
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        try {
//            call = context as WizaredPagerCallback
//        } catch (e: ClassCastException) {
//            throw ClassCastException(context.toString() + " must implement IFragmentToActivity")
//        }
//
//    }
//
//    override fun onDetach() {
//        call = null
//        super.onDetach()
//    }
}