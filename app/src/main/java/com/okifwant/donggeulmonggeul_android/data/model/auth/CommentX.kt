package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class CommentX(
    @SerializedName("commentReport")
    val commentReport: List<CommentReportX>,
    @SerializedName("content")
    val content: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("groupIdx")
    val groupIdx: Int,
    @SerializedName("idx")
    val idx: String,
    @SerializedName("postIdx")
    val postIdx: Int,
    @SerializedName("userId")
    val userId: String
)