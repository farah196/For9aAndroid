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
import com.example.farahal_kiswani.for9a.wizard.interfaces.DataCallback
import com.example.farahal_kiswani.for9a.wizard.interfaces.InterestFragmentCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.viewModel.InterestViewModel


class InterestFragment : BaseWizaredFragment(),
    InterestFragmentCallback {

    lateinit var interstViewModel: InterestViewModel
    var wizaredCallback: WizaredPagerCallback? = null
//    var dataCallback: DataCallback? = null
    val finalFragment:FinalFragment = FinalFragment()
   val args:Bundle = Bundle()

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
            args.putString("name",name)
            finalFragment.arguments=args
            fragmentManager!!.beginTransaction().add(finalFragment,name).commit()
            wizaredCallback!!.onNext()
            //login()
        }
    }

//    fun setFragmentCallback(callback: DataCallback) {
//        this.dataCallback = callback
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            wizaredCallback = context as WizaredPagerCallback
//            dataCallback = activity as DataCallback


        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement IFragmentToActivity")
        }

    }

    override fun onDetach() {
        wizaredCallback = null
//        dataCallback=null
        super.onDetach()
    }


}

