package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class CommentReport(
    @SerializedName("commentIdx")
    val commentIdx: Int,
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("userId")
    val userId: String
)