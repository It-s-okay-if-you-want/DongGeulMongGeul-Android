package com.okifwant.donggeulmonggeul_android.dto

data class UserData(

    val id :String,
    val pw : String,
    val nick : String,
    val local : String,
    val post : PostData,
    val postLikes : List<PostLikesData>,
    val group : GroupData,
    val token : String,
    val refreshToken : String
)