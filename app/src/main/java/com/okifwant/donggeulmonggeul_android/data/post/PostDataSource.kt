package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.post.dto.PostImageResponse
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import okhttp3.MultipartBody
import retrofit2.Response

class PostDataSource(private val postApi: PostApi) {

    suspend fun postImage(image: MultipartBody.Part): Response<PostImageResponse> =
        postApi.postImage(image)

    suspend fun post(postRequest: PostRequest): Response<Unit> =
        postApi.post(postRequest)
}