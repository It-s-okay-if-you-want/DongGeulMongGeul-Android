package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.post.dto.PostImageResponse
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface PostApi {

    @Multipart
    @POST("/upload")
    fun postImage(
        @Part image: MultipartBody.Part
    ): Response<PostImageResponse>

    @POST("/post")
    fun post(@Body request: PostRequest): Response<Unit>
}