package com.example.farahal_kiswani.for9a.signUp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.farahal_kiswani.for9a.R
import kotlinx.android.synthetic.main.countries_fragment.*

class Fragment1 : Fragment() {


    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.countries_fragment,null)

        return v

    }


    companion object {


        fun getInstance(): Fragment1 {

            val obj = Fragment1()



            return obj

        }



    }


}