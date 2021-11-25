package com.okifwant.donggeulmonggeul_android.data.model.newpop


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("category")
    val category : String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: String
)