package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.app.Activity
import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.farahal_kiswani.for9a.wizard.interfaces.PersonalInfoFragmentCallback


class PersonalInfoViewModel(val personalInfoCallback: PersonalInfoFragmentCallback) : BaseObservable() {

    val mBirthday=ObservableField<String>("")
    val mResidence=ObservableField<String>("")
    val mPhone=ObservableField<String>("")
    val mEducationalLevel=ObservableField<String>("")
    val mSpecialization=ObservableField<String>("")

    fun onLoginButtonClicked(view:View){
        personalInfoCallback.onLoginClicked(mBirthday.get()!!,mResidence.get()!!,mPhone.get()!!,mEducationalLevel.get()!!,mSpecialization.get()!!)
    }

    fun onLoginFailed(message:String){

    }
    fun back (view:View)
    {
        personalInfoCallback.onBack()
    }

    fun hideSoftKeyboard(activity: Activity) {
        val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            activity.currentFocus.getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS
        )

    }
}