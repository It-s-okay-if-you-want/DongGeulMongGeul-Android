package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)