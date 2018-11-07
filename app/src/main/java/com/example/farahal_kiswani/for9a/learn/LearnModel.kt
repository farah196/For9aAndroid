package com.example.farahal_kiswani.for9a.learn

class LearnModel {
    private var title: String? = null
    private var imageUrl: String? = null
    private var type: String? = null


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



}