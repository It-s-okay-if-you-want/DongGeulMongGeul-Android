package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.dto.CommentRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CommentApi {
    @POST("comment/{idx}")
    fun postComment(
        @Header("Authorization") token: String,
        @Body request: CommentRequest
    ): Response<Unit>
}