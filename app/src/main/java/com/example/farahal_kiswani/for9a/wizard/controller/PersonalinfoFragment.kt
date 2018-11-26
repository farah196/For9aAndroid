package com.example.farahal_kiswani.for9a.wizard.controller

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.farahal_kiswani.for9a.R

import com.example.farahal_kiswani.for9a.databinding.FragmentPersonalinfoBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.PersonalInfoFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.model.UserModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.PersonalInfoViewModel


class PersonalinfoFragment : BaseWizaredFragment(), PersonalInfoFragmentCallback {

    lateinit var personalInfoViewModel: PersonalInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentPersonalinfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_personalinfo, container, false)
        personalInfoViewModel = PersonalInfoViewModel(this)
        binding.viewPersonalInfo = personalInfoViewModel


        return binding.getRoot()

    }

    override fun onBack() {
        mCallback!!.onBack()
    }




    override fun onLoginClicked(
        mBirthday: String,
        mResidence: String,
        mPhone: String,
        mEducationalLevel: String,
        mSpecialization: String
    )

    {
        val info: UserModel.PersonalInfo = UserModel.PersonalInfo()
        info.mBirthday = mBirthday
        info.mResidence = mResidence
        info.mPhone = mPhone
        info.mEducationalLevel = mEducationalLevel
        info.mSpecialization = mSpecialization
        mCallback!!.onNext(info, WizaredActivity.DataTypes.UserPersonalInfo)
        personalInfoViewModel.hideSoftKeyboard(this.activity!!)
    }

}

