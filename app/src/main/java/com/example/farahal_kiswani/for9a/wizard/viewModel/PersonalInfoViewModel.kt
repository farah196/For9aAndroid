package com.example.farahal_kiswani.for9a.wizard.viewModel

import android.R
import android.app.Activity
import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.farahal_kiswani.for9a.wizard.interfaces.PersonalInfoFragmentCallback
import kotlinx.android.synthetic.main.fragment_personalinfo.*


class PersonalInfoViewModel(val personalInfoCallback: PersonalInfoFragmentCallback) : BaseObservable(), AdapterView.OnItemSelectedListener {
    var list_of_items = arrayOf( "أنثى", "ذكر")
    lateinit var mSelectedGender: String
    val mBirthday=ObservableField<String>("")
    val mResidence=ObservableField<String>("")
    val mPhone=ObservableField<String>("")
    val mEducationalLevel=ObservableField<String>("")
    val mSpecialization=ObservableField<String>("")


    fun setSpinner (spinner : Spinner)
    {
        spinner.setOnItemSelectedListener(this)
        val spinnerAdapter = ArrayAdapter<String>(personalInfoCallback.getContext(), R.layout.simple_spinner_dropdown_item, list_of_items)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(spinnerAdapter)
    }

    fun onLoginButtonClicked(view:View){
        personalInfoCallback.onLoginClicked(mSelectedGender,mBirthday.get()!!,mResidence.get()!!,mPhone.get()!!,mEducationalLevel.get()!!,mSpecialization.get()!!)
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
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent!!.getItemAtPosition(position)
        mSelectedGender= item.toString()
    }
}