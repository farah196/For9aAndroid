package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentFinalBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.DataCallback
import com.example.farahal_kiswani.for9a.wizard.interfaces.FinalCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.viewModel.FinalViewModel


class FinalFragment : BaseWizaredFragment(),
    FinalCallback {


    lateinit var finalViewModel: FinalViewModel
    var wizaredCallback: WizaredPagerCallback? = null
    val getValue = arguments!!.getString("name")
    //    var interestFragment: InterestFragment = InterestFragment()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentFinalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_final, container, false
        )
//        interestFragment.setFragmentCallback(this)
        finalViewModel = FinalViewModel(this)
        binding.viewFinal = finalViewModel

        finalViewModel.final.set(getValue)
        return binding.getRoot()

    }

    override fun final() {
        wizaredCallback!!.onFinish()
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
