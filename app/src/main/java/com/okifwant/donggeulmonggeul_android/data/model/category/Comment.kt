package com.okifwant.donggeulmonggeul_android.data.model.category

data class Comment(
    val commentReport: List<CommentReport>,
    val content: String,
    val createdAt: String,
    val groupIdx: Int,
    val idx: String,
    val postIdx: Int,
    val userId: String
)