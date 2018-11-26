package com.example.farahal_kiswani.for9a.wizard.model



class UserModel {

    var loginInfo: LoginInfo = LoginInfo()

    var personalInfo: PersonalInfo = PersonalInfo()

    data class LoginInfo(var mFirstName: String, var mLastName: String, var mEmail: String, var mPassword: String) {
        constructor() : this(
            "", "",
            "", ""
        )
    }

    class PersonalInfo(
        var mGender: String,
        var mBirthday: String,
        var mResidence: String,
        var mPhone: String,
        var mEducationalLevel: String,
        var mSpecialization: String
    ) {
        constructor() : this(
            "", "",
            "", "", "", ""
        )
    }
}
