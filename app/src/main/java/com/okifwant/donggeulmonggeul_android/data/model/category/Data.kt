package com.okifwant.donggeulmonggeul_android.data.model.category

data class Data(
    val category: String,
    val comment: List<Comment>,
    val content: String,
    val createdAt: String,
    val idx: Int,
    val image: String,
    val postLike: Int,
    val postLikes: List<PostLike>,
    val postReport: List<PostReport>,
    val title: String,
    val userId: String
)