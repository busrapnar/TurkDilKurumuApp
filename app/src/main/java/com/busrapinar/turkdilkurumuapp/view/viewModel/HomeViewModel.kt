package com.busrapinar.turkdilkurumuapp.view.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busrapinar.turkdilkurumuapp.data.AtasozuResponse
import com.busrapinar.turkdilkurumuapp.network.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val apiClient = ApiClient.createService()

    val mutableAtasozuResponse = MutableLiveData<AtasozuResponse>()

    fun getAtasozu(){
        viewModelScope.launch {
            apiClient.getAtasozu().enqueue(object : Callback<AtasozuResponse> {
                override fun onResponse(
                    call: Call<AtasozuResponse>,
                    response: Response<AtasozuResponse>
                ) {
                    mutableAtasozuResponse.value = response.body()
                }

                override fun onFailure(call: Call<AtasozuResponse>, t: Throwable) {
                    Log.d("Error", "onFailure: ${t.message}")
                }
            })
        }
    }
}