package com.okifwant.donggeulmonggeul_android.dto

data class GroupData(

    val idx : Int,
    val title : String,
    val content : String,
    val category: String,
    val date : String,
    val place : String,
    val image : String,
    val postLike : Int,
    val createdAt : String,
    val userId :String,
    val commentData: List<CommentData>,
    val postLikes : PostLikesData
)
