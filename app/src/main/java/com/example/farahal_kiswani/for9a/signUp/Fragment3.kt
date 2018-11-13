package com.example.farahal_kiswani.for9a.signUp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R

class Fragment3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.step1_fragment, null)


        return v

    }


    companion object {


        fun getInstance(): Fragment3 {

            val obj = Fragment3()



            return obj

        }
    }
}