package com.okifwant.donggeulmonggeul_android.dto

data class PostDetailResponse(val data: PostDetailData)

data class PostDetailData(
    val idx: Int,
    val title: String,
    val content: String,
    val image: String,
    val category: String,
    val postLike: Int,
    val createdAt: String,
    val userId: String,
    val comment: List<CommentData>
)