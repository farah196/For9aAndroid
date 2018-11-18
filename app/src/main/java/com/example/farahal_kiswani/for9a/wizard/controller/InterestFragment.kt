package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentInterestBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.InterestFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.viewModel.InterestViewModel


class InterestFragment : BaseWizaredFragment(),
    InterestFragmentCallback
{

    lateinit var interstViewModel: InterestViewModel
    var wizaredCallback: WizaredPagerCallback? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentInterestBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_interest, container, false)
        interstViewModel = InterestViewModel(this)
        binding.viewInterest = interstViewModel

        return binding.getRoot()

    }

    override fun onLoginClicked(name: String) {
//        if(password.length < 6){
//            interstViewModel.onLoginFailed("test error")
//            return
//        }


        // send name in call back to final fragment

        wizaredCallback!!.onNext()
        //login()

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
