package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentLogininfoBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.LoginInfoFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.model.UserModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.LoginInfoViewModel


class LoginInfoFragment : BaseWizaredFragment(),
    LoginInfoFragmentCallback {


    lateinit var loginInfoViewModel: LoginInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentLogininfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_logininfo, container, false)
        loginInfoViewModel = LoginInfoViewModel(this)
        binding.viewLoginInfo = loginInfoViewModel

        return binding.getRoot()

    }


    override fun onSignClicked(firstname: String, lastname: String, email: String, password: String) {
        val info: UserModel.LoginInfo = UserModel.LoginInfo()

        info.mFirstName = firstname
        info.mLastName = lastname
        info.mEmail = email
        info.mPassword = password
        if (firstname.equals("") || lastname.equals("") || email.equals("") || password.equals("")) {
            Toast.makeText(this.context, "أكمل بياناتك", Toast.LENGTH_LONG).show()
        } else {
            mCallback!!.onNext(info, WizaredActivity.DataTypes.UserLoginInfo)
        }
    }



}