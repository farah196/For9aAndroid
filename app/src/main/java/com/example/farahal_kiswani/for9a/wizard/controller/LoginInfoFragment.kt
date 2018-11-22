package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
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
    var wizaredCallback: WizaredPagerCallback? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentLogininfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_logininfo, container, false)
        loginInfoViewModel = LoginInfoViewModel(this)
        binding.viewSignUp = loginInfoViewModel

        this.mCallback = wizaredCallback
        return binding.getRoot()

    }

    fun validation(): Boolean {
        if (UserModel().loginInfo.mFirstName.equals("")) {
            Toast.makeText(this.context, "أدخل الاسم", Toast.LENGTH_LONG).show()

        }
        if (UserModel().loginInfo.mLastName.equals("")) {
            Toast.makeText(this.context, "أدخل العائلة", Toast.LENGTH_LONG).show()

        }

        if (UserModel().loginInfo.mPassword.equals("")) {
            Toast.makeText(this.context, "أدخل كلمة السر", Toast.LENGTH_LONG).show()

        }
        return true
    }

    private fun isValidMail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    override fun onSignClicked(firstname: String, lastname: String, email: String, password: String) {
        val info: UserModel.LoginInfo = UserModel.LoginInfo()

        info.mFirstName = firstname
        info.mLastName = lastname
        info.mEmail = email
        info.mPassword = password
        if (firstname.equals("") || lastname.equals("") || email.equals("") || password.equals("")) {
            Toast.makeText(this.context, "أكمل بياناتك", Toast.LENGTH_LONG).show()
        }
        else
        {
            wizaredCallback!!.onNext(info, WizaredActivity.DataTypes.UserLoginInfo)
        }
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