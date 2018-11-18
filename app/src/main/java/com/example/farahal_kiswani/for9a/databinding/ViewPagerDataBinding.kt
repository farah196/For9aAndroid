package com.example.farahal_kiswani.for9a.databinding


import android.databinding.BindingAdapter
import android.support.v4.view.ViewPager
import com.example.farahal_kiswani.for9a.wizard.CustomViewPager
import com.example.farahal_kiswani.for9a.wizard.ViewPagerAdapter


class ViewPagerDataBinding{
    @BindingAdapter("app:adapter")
    fun bind(viewPager: ViewPager, adapter: ViewPagerAdapter) {
        viewPager.adapter = adapter

    }

}