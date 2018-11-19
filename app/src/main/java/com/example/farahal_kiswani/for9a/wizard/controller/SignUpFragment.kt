package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentSignupBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.SignUpFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.viewModel.SignUpViewModel

class SignUpFragment : BaseWizaredFragment(),
    SignUpFragmentCallback {

    lateinit var signupViewModel: SignUpViewModel
    var wizaredCallback: WizaredPagerCallback?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentSignupBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        signupViewModel= SignUpViewModel(this)
        binding.viewSignUp = signupViewModel

        return binding.getRoot()

    }

    override fun onSignClicked(email: String) {

        if (email.equals(""))
        {
            Toast.makeText(this.context, "please enter your email", Toast.LENGTH_LONG).show()
        }
        else
        {
            val bundle = Bundle()
            bundle.putString("my_key2", email)
            val myFrag = FinalFragment()
            myFrag.setArguments(bundle)
            fragmentManager!!.beginTransaction()
                .add(R.id.fragment_container, myFrag, "myFrag")
                .commit()

            wizaredCallback!!.onNext()
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

