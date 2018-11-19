package com.example.farahal_kiswani.for9a.wizard.controller

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentInterestBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.InterestFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.viewModel.InterestViewModel
import android.R.attr.key




class InterestFragment : BaseWizaredFragment(),
    InterestFragmentCallback {

    lateinit var interstViewModel: InterestViewModel
    var wizaredCallback: WizaredPagerCallback? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentInterestBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_interest, container, false)
        interstViewModel = InterestViewModel(this)
        binding.viewInterest = interstViewModel


        return binding.getRoot()

    }

    @SuppressLint("CommitTransaction")
    override fun onLoginClicked(name: String) {
//        if(password.length < 6){
//            interstViewModel.onLoginFailed("test error")
//            return
//        }


        // send name in call back to final fragment
        if (name.equals("")) {
            Toast.makeText(this.context, "please enter your name", Toast.LENGTH_LONG).show()
        } else {
//            val bundle = Bundle()
//            bundle.putString("my_key", name)
//            val myFrag = FinalFragment()
//            myFrag.setArguments(bundle)
//            fragmentManager!!.beginTransaction()
//                .add(R.id.fragment_container, myFrag, "myFrag")
//                .commit()

            wizaredCallback!!.onNext("Test",WizaredActivity.DataTypes.Categories)


            //login()
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

