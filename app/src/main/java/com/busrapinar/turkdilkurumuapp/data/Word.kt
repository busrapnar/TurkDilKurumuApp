package com.busrapinar.turkdilkurumuapp.data

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Word(
   val id : Int ,
   val title :String,
   val word : String,
   val explanation : String
) : Serializable
