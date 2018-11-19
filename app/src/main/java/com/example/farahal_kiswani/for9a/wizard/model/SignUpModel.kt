package com.example.farahal_kiswani.for9a.wizard.model

class SignUpModel {
    var mFirstName: String? = null
    var mLastName: String? = null
    var mEmail: String? = null
    var mPassword: String? = null
    var mGender: String? = null
    var mBirthday: String? = null
    var mResidence: String? = null
    var mPhone: String? = null
    var mEducationalLevel: String? = null
    var mSpecialization: String? = null


    fun getFirstName(): String? {
        return mFirstName
    }

    fun setFirstName(firstName: String?) {
        this.mFirstName = firstName
    }

    fun getLastName(): String? {
        return mLastName
    }

    fun setLastName(lastName: String?) {
        this.mLastName = lastName
    }

    fun getEmail(): String? {
        return mEmail
    }


    fun setEmail(email: String?) {
        this.mEmail = email
    }

    fun getPassword(): String? {
        return mPassword
    }

    fun setPassword(password: String?) {
        this.mPassword = password
    }

    fun getGender(): String? {
        return mGender
    }

    fun setGender(gender: String?) {
        this.mGender = gender
    }

    fun getBirthday(): String? {
        return mBirthday
    }


    fun setBirthday(birthday: String?) {
        this.mBirthday = birthday
    }



    fun getResidence(): String? {
        return mResidence
    }

    fun setResidence(residence: String?) {
        this.mResidence = residence
    }

    fun getPhone(): String? {
        return mPhone
    }

    fun setPhone(phone: String?) {
        this.mPhone = phone
    }

    fun getEducationalLevel(): String? {
        return mEducationalLevel
    }


    fun setEducationalLevel(educationalLevel: String?) {
        this.mEducationalLevel = educationalLevel
    }

    fun getSpecialization(): String? {
        return mSpecialization
    }

    fun setSpecialization(specialization: String?) {
        this.mSpecialization = specialization
    }

}