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
import com.example.farahal_kiswani.for9a.opportunity.OpportunityModel
import com.example.farahal_kiswani.for9a.wizard.adapter.ViewPagerAdapter
import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity.DataTypes.*
import com.example.farahal_kiswani.for9a.wizard.interfaces.WizaredPagerCallback
import com.example.farahal_kiswani.for9a.wizard.model.FilterModel
import com.example.farahal_kiswani.for9a.wizard.model.IdTitleModel
import com.example.farahal_kiswani.for9a.wizard.model.UserModel
import com.example.farahal_kiswani.for9a.wizard.util.BaseWizaredFragment
import com.example.farahal_kiswani.for9a.wizard.util.CustomViewPager
import com.example.farahal_kiswani.for9a.wizard.viewModel.WizaredViewModel

import java.util.ArrayList
import java.util.logging.Filter

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
    val mFilterFragment: FilterFragment = FilterFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
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
        val mCountriesList: ArrayList<FilterModel> = getFilterItems(Countries)
        (mFragment as FilterFragment).setData(mCountriesList)
        mFragments.add(mFragment)


        mFragment = FilterFragment()
        mFragment.setCallback(this)
        mFragment.setType(Interests)
        val mInterestList: ArrayList<FilterModel> = getFilterItems(Interests)
        (mFragment as FilterFragment).setData(mInterestList)
        mFragments.add(mFragment)



        mFragment = FilterFragment()
        mFragment.setCallback(this)
        mFragment.setType(Categories)
        val mCategoryList: ArrayList<FilterModel> = getFilterItems(Categories)
        (mFragment as FilterFragment).setData(mCategoryList)
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

        when (dataType) {
            Countries -> return getCountriesFilters()
            Interests -> return getInterestsFilters()
            Categories -> return getCategoriesFilters()
        }

        return getCategoriesFilters()
    }

    fun getCategoriesFilters(): ArrayList<FilterModel> {
        val titles: ArrayList<String> = ArrayList()
        titles.add("تبادل ثقافي")
        titles.add("فرص عمل")
        titles.add("فرص تعليم")
        titles.add("منحة مالية")
        titles.add(" دورات عبر الإنترنت")
        val codeList : ArrayList<String> = ArrayList()
        codeList.add ("101")
        codeList.add ("102")
        codeList.add ("103")
        codeList.add ("104")
        codeList.add ("105")

        val filterList: ArrayList<FilterModel> = ArrayList()

        for (i in 0 until titles.size) {
            val filterModel = FilterModel(Categories)
            filterModel.setText(titles[i])
            filterModel.setID(codeList[i])
            filterList.add(filterModel)

        }

        return filterList
    }

    fun getInterestsFilters(): ArrayList<FilterModel> {
        val filterList: ArrayList<FilterModel> = ArrayList()
        val titles: ArrayList<String> = ArrayList()


        titles.add("زراعة")
        titles.add("علوم")
        titles.add("رياضة")
        titles.add("فنون")

        val idList : ArrayList<String> = ArrayList()
        idList.add ("201")
        idList.add ("202")
        idList.add ("203")
        idList.add ("204")
        idList.add ("205")
        for (i in 0 until titles.size)
        {
            val filterModel = FilterModel(Interests)
            filterModel.setText(titles[i])
            filterModel.setID(idList[i])
            filterList.add(filterModel)
        }

        return filterList
    }

    fun getCountriesFilters(): ArrayList<FilterModel> {

        val filterList: ArrayList<FilterModel> = ArrayList()
        val titles: ArrayList<String> = ArrayList()

        titles.add("الاردن")
        titles.add("مصر")
        titles.add("السودان")
        titles.add("المغرب")
        titles.add("فلسطين")
        val idList : ArrayList<String> = ArrayList()
        idList.add ("301")
        idList.add ("302")
        idList.add ("303")
        idList.add ("304")
        idList.add ("305")

        for (i in 0 until titles.size)
        {
            val filterModel = FilterModel(Countries)
            filterModel.setText(titles[i])
            filterModel.setID(idList[i])
            filterList.add(filterModel)
        }

        return filterList


    }

    override fun onNext(ob: Any, dataType: DataTypes) {
        saveData(ob, dataType)
        if (currentFragmentPosition < mFragments.size - 1) {
            currentFragmentPosition++

            viewPager.currentItem = currentFragmentPosition
        } else {
            onFinish(ob, dataType)
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

            UserLoginInfo -> saveLoginInfo(ob as UserModel.LoginInfo)
            UserPersonalInfo -> savePersonalInfo(ob as UserModel.PersonalInfo)

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