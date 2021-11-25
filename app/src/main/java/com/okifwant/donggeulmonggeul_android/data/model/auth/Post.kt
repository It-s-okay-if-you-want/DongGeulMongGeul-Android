package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("category")
    val category: String,
    @SerializedName("comment")
    val comment: List<CommentX>,
    @SerializedName("content")
    val content: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("postLike")
    val postLike: Int,
    @SerializedName("postLikes")
    val postLikes: List<PostLikeX>,
    @SerializedName("postReport")
    val postReport: List<PostReport>,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: String
)