package com.busrapinar.turkdilkurumuapp.data

import com.google.gson.annotations.SerializedName

data class Atasozu(
    val anahtar: String,
    val anlami: String,
    val atara: String,
    val gosterim_tarihi: String,
    @SerializedName("soz_id")
    val id: Int,
    val sozum: String,
    val turu2: String
){
    val idInt = this.id.toInt()
}