package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class CommentReportX(
    @SerializedName("commentIdx")
    val commentIdx: Int,
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("userId")
    val userId: String
)