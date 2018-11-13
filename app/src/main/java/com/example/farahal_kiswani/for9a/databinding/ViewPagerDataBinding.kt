package com.example.farahal_kiswani.for9a.databinding

import android.support.v4.view.ViewPager
import android.databinding.BindingAdapter
import com.example.farahal_kiswani.for9a.signUp.TabPagerAdapter


class ViewPagerDataBinding {
    @BindingAdapter("app:adapter")
    fun bind(viewPager: ViewPager, adapter: TabPagerAdapter) {
        viewPager.adapter = adapter

    }

}