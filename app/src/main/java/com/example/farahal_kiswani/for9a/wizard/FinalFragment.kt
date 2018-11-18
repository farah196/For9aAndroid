package com.example.farahal_kiswani.for9a.wizard

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentFinalBinding
import com.example.farahal_kiswani.for9a.databinding.FragmentSignupBinding

class FinalFragment : BaseWizaredFragment() {

    var finalViewModel: FinalViewModel = FinalViewModel()
    var call: WizaredPagerCallback? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentFinalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_final, container, false
        )
        binding.viewFinal = finalViewModel
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
        call = null
        super.onDetach()
    }
}