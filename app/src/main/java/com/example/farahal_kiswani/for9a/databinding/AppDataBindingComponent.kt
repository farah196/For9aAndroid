package com.example.farahal_kiswani.for9a.databinding


class AppDataBindingComponent : android.databinding.DataBindingComponent {


    override fun getFilterRecyclerViewDataBinding(): FilterRecyclerViewDataBinding {
        return FilterRecyclerViewDataBinding()
    }


    override fun getCategoryFilterViewDataBinding(): CategoryFilterViewDataBinding {
        return CategoryFilterViewDataBinding()
    }

    override fun getLearnRecyclerViewDataBinding(): LearnRecyclerViewDataBinding {
        return LearnRecyclerViewDataBinding()
    }

    override fun getOpportunityRecyclerViewDataBinding(): OpportunityRecyclerViewDataBinding {
        return OpportunityRecyclerViewDataBinding()
    }


}