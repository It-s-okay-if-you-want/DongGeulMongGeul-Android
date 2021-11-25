package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.data.model.auth.Auth
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Post
import retrofit2.http.GET
import retrofit2.http.Header

interface PostService {

    @GET("/post/new")
    suspend fun viewTest(
        @Header("authorization") token : String): Post

    @GET("/post/hot")
    suspend fun viewPop(
        @Header("authorization") token : String): Post

    @GET("/auth")
    suspend fun viewAuth(
    @Header("authorization") token : String): Auth

}