package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.dto.CommentRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentApi {
    @POST("comment/{idx}")
    suspend fun postComment(
        @Path("idx") idx: Int,
        @Header("Authorization") token: String,
        @Body request: CommentRequest
    ): Response<Unit>
}