package com.example.farahal_kiswani.for9a.signUp

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.databinding.ActivitySignupBinding


class SignUpActivity : AppCompatActivity() {
    private var singUpViewModel: SignUpViewModel = SignUpViewModel(supportFragmentManager)
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mCallback: SignUpCallback? = null
        val view = bind()
        initViewPager(view)
        mCallback!!.onNext(view)
    }



    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivitySignupBinding>(this, R.layout.activity_signup)
        binding.viewSignUp = singUpViewModel

        return binding.getRoot()


    }


    private fun initViewPager(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val viewPager = view.findViewById<CustomViewPager>(R.id.viewpager)
        viewPager.offscreenPageLimit = 3
        viewPager.setPagingEnabled(false)
    }

}



