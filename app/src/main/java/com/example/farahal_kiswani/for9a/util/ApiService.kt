package com.example.farahal_kiswani.for9a.util

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/user/full-register")
    fun getRegister(@Query("count") count: Int?, @Query("since_id") rand: String?, @Query("term") term: String?): retrofit2.Call<String>

}