package com.example.farahal_kiswani.for9a.wizard.controller

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle


import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.for9a.R

import com.example.farahal_kiswani.for9a.databinding.ActivityWizaredBinding
import com.example.farahal_kiswani.for9a.opportunity.OpportunityActivity
import com.example.farahal_kiswani.for9a.wizard.adapter.ViewPagerAdapter
import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity.DataTypes.*
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.model.UserModel
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.util.CustomViewPager
import com.example.farahal_kiswani.for9a.wizard.viewModel.FilterViewModel
import com.example.farahal_kiswani.for9a.wizard.viewModel.WizaredViewModel

import java.util.ArrayList

class WizaredActivity : AppCompatActivity(), WizaredPagerCallback {


    enum class DataTypes {
        Categories,
        Countries,
        Interests,
        UserLoginInfo,
        UserPersonalInfo,
        None;
    }

    var user: UserModel = UserModel()
    lateinit var viewPager: CustomViewPager
    var wizaredViewModel: WizaredViewModel =
        WizaredViewModel(supportFragmentManager)
    var mFragments = ArrayList<BaseWizaredFragment>()
    var currentFragmentPosition = 0
    var mAdapter: ViewPagerAdapter? = null
val mFilterFragment:FilterFragment = FilterFragment()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val view: View = bind()
        initViewPager(view)
    }


    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivityWizaredBinding>(this, R.layout.activity_wizared)
        binding.viewWizared = wizaredViewModel
        return binding.getRoot()

    }


    private fun initViewPager(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        viewPager = view.findViewById<CustomViewPager>(R.id.viewpager)

        viewPager.setPagingEnabled(false)

        var mFragment: BaseWizaredFragment =
            LoginInfoFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)


        mFragment = PersonalinfoFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)

        mFragment = FilterFragment()
        mFragment.setCallback(this)

       mFragment.setType(Countries)

        val mCountriesList:ArrayList<FilterModel> = getFilterItems(Countries)
        (mFragment as FilterFragment).getData(mCountriesList)
        mFragments.add(mFragment)


        mFragment = FilterFragment()
        mFragment.setCallback(this)
        mFragment.setType(Interests)
        val mInterestList:ArrayList<FilterModel> = getFilterItems(Interests)
        (mFragment as FilterFragment).getData(mInterestList)
        mFragments.add(mFragment)





        mFragment = FilterFragment()
        mFragment.setCallback(this)
        mFragment.setType(Categories)
        val mCategoryList:ArrayList<FilterModel> = getFilterItems(Categories)
        (mFragment as FilterFragment).getData(mCategoryList)
        mFragments.add(mFragment)

        mFragment = FinalFragment()
        mFragment.setCallback(this)
        mFragments.add(mFragment)


        mAdapter = ViewPagerAdapter(supportFragmentManager, mFragments)
        viewPager.adapter = mAdapter


    }

    override fun onFinish(ob: Any?, dataType: DataTypes) {
        val intent = Intent(this, OpportunityActivity::class.java)
        startActivity(intent)

    }

    private fun getFilterItems(dataType: DataTypes): ArrayList<FilterModel> {
     val   interestOb:FilterModel =FilterModel("تبادل ثقافي",true,"2",Interests)
        val  countryOb:FilterModel =FilterModel("مصر",true,"2",Countries)
        val   categoryOb:FilterModel =FilterModel("علوم",true,"2",Categories)

        val interestList: ArrayList<FilterModel> = ArrayList()
        interestList.add(interestOb)


        val categoryList: ArrayList<FilterModel> = ArrayList()
        interestList.add(categoryOb)


        val countryList: ArrayList<FilterModel> = ArrayList()
        interestList.add(countryOb)


        when(dataType){
            Countries -> return countryList
            Interests ->return interestList
            Categories->return categoryList

        }
        return categoryList
    }

    override fun onNext(ob: Any, dataType: DataTypes) {
        saveData(ob, dataType)
        if (currentFragmentPosition < mFragments.size - 1) {
            currentFragmentPosition++

            viewPager.currentItem = currentFragmentPosition
        } else {
            onFinish(ob,dataType)
        }
    }

    override fun onBack() {
        if (currentFragmentPosition < mFragments.size - 1) {
            currentFragmentPosition--

            viewPager.currentItem = currentFragmentPosition
        }
    }

    fun saveData(ob: Any, dt: DataTypes) {
        when (dt) {
            Countries -> TODO()
            Interests -> TODO()
            UserLoginInfo -> saveLoginInfo(ob as UserModel.LoginInfo)
            UserPersonalInfo -> savePersonalInfo(ob as UserModel.PersonalInfo)
            Categories -> TODO()
            None-> TODO()
        }
    }

    fun saveLoginInfo(info: UserModel.LoginInfo) {
        user.loginInfo = info
    }

    fun savePersonalInfo(info: UserModel.PersonalInfo) {
        user.personalInfo = info
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (currentFragmentPosition < mFragments.size - 1) {
            currentFragmentPosition--

            viewPager.currentItem = currentFragmentPosition
        }
    }
}