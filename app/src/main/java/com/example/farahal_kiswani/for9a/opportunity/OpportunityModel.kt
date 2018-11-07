package com.example.farahal_kiswani.for9a.opportunity

class OpportunityModel {
    private var title: String? = null
    private var imageUrl: String? = null
    private var type: String? = null
    private var views: Int? = null
    private var organization: String? = null
    private var imageOrganizationUrl: String? = null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String?) {
        this.imageUrl = imageUrl

    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type

    }


    fun getView(): Int? {
        return views
    }

    fun setViews(views: Int?) {
        this.views = views

    }

    fun getOrganization(): String? {
        return organization
    }

    fun setOrganization(organization: String?) {
        this.organization = organization

    }


    fun getImageOrganizationUrl(): String? {
        return imageOrganizationUrl
    }

    fun setImageOrganizationUrl(imageOrganizationUrl: String?) {
        this.imageOrganizationUrl = imageOrganizationUrl

    }


}