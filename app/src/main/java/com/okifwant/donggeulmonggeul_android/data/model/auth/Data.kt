package com.okifwant.donggeulmonggeul_android.data.model.auth


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("group")
    val group: List<Group>,
    @SerializedName("id")
    val id: String,
    @SerializedName("local")
    val local: String,
    @SerializedName("nick")
    val nick: String,
    @SerializedName("post")
    val post: List<Post>,
    @SerializedName("postLikes")
    val postLikes: List<PostLikeXX>,
    @SerializedName("pw")
    val pw: String
)