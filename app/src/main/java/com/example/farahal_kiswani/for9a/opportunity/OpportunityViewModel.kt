package com.example.farahal_kiswani.for9a.opportunity
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.example.farahal_kiswani.for9a.filter.CategoryAdapter
import com.example.farahal_kiswani.for9a.filter.FilterModel
import java.util.ArrayList
import android.databinding.ObservableInt
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import android.widget.Toolbar
import com.example.farahal_kiswani.for9a.R
import com.example.farahal_kiswani.for9a.learn.LearnActivity
import kotlinx.android.synthetic.main.activity_opportunity.*

class OpportunityViewModel (val mContext: Context) : BaseObservable() {
    private var adapter: OpportunityAdapter? = null
    private var data: MutableList<OpportunityModel>? = null
    private var category: CategoryAdapter? = null
    private var filter: MutableList<FilterModel>? = null
    private var isLoading: Boolean = false
    var scrollTo = ObservableInt()
    init {
        data = ArrayList<OpportunityModel>() as MutableList<OpportunityModel>?
        adapter = OpportunityAdapter()
        category = CategoryAdapter()
        filter = ArrayList<FilterModel>()
    }

    fun setUp() {
        fetchData()
    }

    fun setUpFilter() {
        fetchFilter()
    }

    fun setUpLoadMore() {
        scrollTo.set(3)
        setLoading(false)
        fetchData()
    }


    @Bindable
    fun getFilter(): List<FilterModel> {
        return this.filter!!
    }

    @Bindable
    fun getCategory(): CategoryAdapter {
        return this.category!!
    }

    @Bindable
    fun getData(): List<OpportunityModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): OpportunityAdapter {
        return this.adapter!!
    }

     fun drawer (mActivity: Activity, drawerLayout:DrawerLayout, toolbar: android.support.v7.widget.Toolbar
                        ,navigation:NavigationView) {

         val mDrawerToggle: ActionBarDrawerToggle?
         mDrawerToggle = object :

             ActionBarDrawerToggle(mActivity, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

             override fun onDrawerClosed(view: View) {
                 super.onDrawerClosed(view)

             }

             override fun onDrawerOpened(drawerView: View) {
                 super.onDrawerOpened(drawerView)
                 //toast("Drawer opened")
             }
         }


         drawerLayout.addDrawerListener(mDrawerToggle)
         mDrawerToggle.setDrawerIndicatorEnabled(true)

         mDrawerToggle.syncState()

         navigation.setNavigationItemSelectedListener {
             when (it.itemId) {
                 R.id.mLearn -> {
                     val intent = Intent(mContext, LearnActivity::class.java)
                     ContextCompat.startActivity(mContext, intent, Bundle())

                 }

             }
             // Close the drawer
             drawerLayout.closeDrawer(GravityCompat.START)
             true
         }
     }

    private fun fetchData() {
        val titles: ArrayList<String> = ArrayList()
        titles.add("تبادل ثقافي")
        titles.add("فرص عمل")
        titles.add("فرص تعليم")
        titles.add("منحة مالية")
        titles.add("منحة دراسية")
        titles.add("جوائز ومسابقات")
        titles.add("فرص إقامة")
        titles.add(" دورات عبر الإنترنت")
        for (i in 0 until titles.size) {
            val dataModel = OpportunityModel()
            dataModel.setTitle(titles[i])

            data!!.add(dataModel)
        }

        notifyPropertyChanged(BR.data)

    }

    private fun fetchFilter() {

        val titles: ArrayList<String> = ArrayList()
        titles.add("تبادل ثقافي")
        titles.add("فرص عمل")
        titles.add("فرص تعليم")
        titles.add("منحة مالية")
        titles.add("منحة دراسية")
        titles.add("جوائز ومسابقات")
        titles.add("فرص إقامة")
        titles.add(" دورات عبر الإنترنت")
        for (i in 0 until titles.size) {
            val dataModel = FilterModel()
            dataModel.setName(titles[i])

            filter!!.add(dataModel)
        }

        notifyPropertyChanged(BR.filter)
    }

    @Bindable
    fun isLoading(): Boolean {
        return isLoading
    }

    fun setLoading(loading: Boolean) {
        isLoading = loading
        notifyPropertyChanged(BR._all)
    }
}