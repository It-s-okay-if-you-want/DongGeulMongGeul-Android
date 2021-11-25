package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class PostReport(
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("postIdx")
    val postIdx: Int,
    @SerializedName("userId")
    val userId: String
)