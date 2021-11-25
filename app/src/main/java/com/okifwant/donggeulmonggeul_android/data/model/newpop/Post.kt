package com.okifwant.donggeulmonggeul_android.data.model.newpop


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)