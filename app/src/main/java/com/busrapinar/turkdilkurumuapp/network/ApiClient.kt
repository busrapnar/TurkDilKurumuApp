package com.busrapinar.turkdilkurumuapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val baseUrl = "https://raw.githubusercontent.com/busrapnar/MyAPI/main/"

    fun createClient() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createService(): ApiService {
        return createClient().create(ApiService::class.java)
    }
}