package com.example.farahal_kiswani.for9a.signUp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.for9a.R

class Fragment2 : Fragment() {


    val mList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment2, null)


        return v

    }


    companion object {


        fun getInstance(): Fragment2 {

            val obj = Fragment2()



            return obj

        }
    }
}