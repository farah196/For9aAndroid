package com.example.farahal_kiswani.for9a.wizard.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class CountriesModel(name:String, code:String):Serializable {
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


