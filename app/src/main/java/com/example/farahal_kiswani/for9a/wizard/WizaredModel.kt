package com.example.farahal_kiswani.for9a.wizard

class WizaredModel {


    var mLastname: String? = null
    var mAge: String? = null
    var mName: String? = null

    fun getName(): String? {
        return mName
    }

    fun setName(name: String?) {
        this.mName = name
    }

    fun getlastname(): String? {
        return mLastname
    }

    fun setlastname(lastname: String?) {
        this.mLastname = lastname
    }

    fun getage(): String? {
        return mAge
    }


    fun setage(age: String?) {
        this.mAge = age
    }
}