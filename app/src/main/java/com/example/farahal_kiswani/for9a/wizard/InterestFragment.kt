package com.example.farahal_kiswani.for9a.wizard

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentInterestBinding


class InterestFragment:BaseWizaredFragment()
{
    lateinit var call:WizaredPagerCallback
    var interstViewModel: InterestViewModel = InterestViewModel(call)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding : FragmentInterestBinding = DataBindingUtil.inflate(inflater ,R.layout.fragment_interest,container , false)
        binding.viewInterest = interstViewModel
        call.onNext()
      return binding.getRoot()

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            call = context as WizaredPagerCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement IFragmentToActivity")
        }

    }

    override fun onDetach() {

        super.onDetach()
    }
}