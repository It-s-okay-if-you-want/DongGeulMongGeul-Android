package com.okifwant.donggeulmonggeul_android.dto

data class PostData(

    val idx : Int,
    val title : String,
    val content : String,
    val image : String,
    val category :String,
    val postLike : String,
    val createdAt : String,
    val userId : String,
    val comment : CommentData,

)