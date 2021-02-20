package com.example.magazin.data

import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("name")
        val title : String,
        @SerializedName("photo url")
        val photoUrl: String,
        val description:String,
        val price: Double,
        val description2:String,
        val price2: Double,
        val description3:String,
        val price3: Double
)
