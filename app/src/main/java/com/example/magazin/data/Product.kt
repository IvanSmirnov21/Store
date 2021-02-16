package com.example.magazin.data

import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("name")
        val title : String,
        @SerializedName("photo url")
        val photoUrl: String,
        val price: Double)
