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
    var wizaredCallback: WizaredPagerCallback? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentPersonalinfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_personalinfo, container, false)
        personalInfoViewModel = PersonalInfoViewModel(this)
        binding.viewPersonalInfo = personalInfoViewModel

        this.mCallback = wizaredCallback

        return binding.getRoot()

    }

    override fun onBack() {
        wizaredCallback!!.onBack()
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
        wizaredCallback!!.onNext(info, WizaredActivity.DataTypes.UserPersonalInfo)
        personalInfoViewModel.hideSoftKeyboard(this.activity!!)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            wizaredCallback = context as WizaredPagerCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement IFragmentToActivity")
        }

    }

    override fun onDetach() {
        wizaredCallback = null
        super.onDetach()

    }

}

