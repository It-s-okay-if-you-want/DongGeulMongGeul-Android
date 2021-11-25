package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.post.dto.PostImageResponse
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface PostApi {

    @Multipart
    @POST("upload")
    suspend fun postImage(
        @Part images: MultipartBody.Part
    ): Response<PostImageResponse>

    @POST("post")
    suspend fun post(@Body request: PostRequest): Response<Unit>
}