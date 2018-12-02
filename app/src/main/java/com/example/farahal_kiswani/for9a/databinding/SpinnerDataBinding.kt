package com.example.farahal_kiswani.for9a.databinding

import android.databinding.BindingAdapter
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.farahal_kiswani.for9a.wizard.model.GenderModel

class SpinnerDataBinding {
    @BindingAdapter("app:spinneradapter","app:selectedValue")
    fun bind(spinner: Spinner, adapter: ArrayAdapter<GenderModel>, selectedValue:String) {
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, id: Long
            )
            {
                val item = adapterView.getItemAtPosition(position)


            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }

    }
}