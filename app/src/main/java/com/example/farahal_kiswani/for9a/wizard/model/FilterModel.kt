package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity

class FilterModel(dataTypes: WizaredActivity.DataTypes) {
    lateinit var countriesModel: CountriesModel
    lateinit var IdTitleModel:IdTitleModel
    init {
        when(dataTypes)
        {
            WizaredActivity.DataTypes.Categories-> IdTitleModel
            WizaredActivity.DataTypes.Interests-> IdTitleModel
            WizaredActivity.DataTypes.Countries->countriesModel
            else -> {
                 IdTitleModel
            }
        }
    }
}