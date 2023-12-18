package com.busrapinar.turkdilkurumuapp.network

import com.busrapinar.turkdilkurumuapp.data.AtasozuResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("atasozu.json")
    fun getAtasozu() : Call<AtasozuResponse>
}