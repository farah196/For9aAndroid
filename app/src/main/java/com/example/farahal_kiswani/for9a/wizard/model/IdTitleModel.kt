package com.example.farahal_kiswani.for9a.wizard.model

import com.example.farahal_kiswani.for9a.wizard.controller.WizaredActivity
import java.io.Serializable
import com.google.gson.annotations.SerializedName


class IdTitleModel(id: Int, title: String,filterType: WizaredActivity.DataTypes) : Serializable,FilterModel(filterType) {
    @SerializedName("id")
    private var id: Int = 0
    @SerializedName("title")
    private var title: String? = null

    init
    {
        this.id = id
        this.title = title
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    override fun toString(): String {
        return this.title!!
    }

    private var checked: Boolean = false

    fun isChecked(): Boolean {
        return checked
    }

    fun setChecked(checked: Boolean) {
        this.checked = checked
    }
}