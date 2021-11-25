package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("category")
    val category: String,
    @SerializedName("comment")
    val comment: List<Comment>,
    @SerializedName("content")
    val content: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("postLike")
    val postLike: Int,
    @SerializedName("postLikes")
    val postLikes: List<PostLike>,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: String
)