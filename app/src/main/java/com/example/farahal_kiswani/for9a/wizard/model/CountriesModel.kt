package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class CountriesModel(name:String, code:String,filterType: WizaredActivity.DataTypes):Serializable,FilterModel("",false,"",filterType) {
    @SerializedName("title")
   var name:String
    @SerializedName("code")
    var code:String

    init {
        this.name = name
        this.code = code
    }
     override fun toString():String {
        return name
    }
}


