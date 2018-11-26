package com.example.farahal_kiswani.for9a.wizard.controller
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.FragmentFinalBinding
import com.example.farahal_kiswani.for9a.wizard.interfaces.FinalCallback
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.viewModel.FinalViewModel


class FinalFragment : BaseWizaredFragment(),
    FinalCallback {


    lateinit var finalViewModel: FinalViewModel

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentFinalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_final, container, false
        )
        finalViewModel = FinalViewModel(this)
        binding.viewFinal = finalViewModel


        return binding.getRoot()

    }

    override fun final() {
        mCallback!!.onFinish(null,WizaredActivity.DataTypes.None)
    }


}
