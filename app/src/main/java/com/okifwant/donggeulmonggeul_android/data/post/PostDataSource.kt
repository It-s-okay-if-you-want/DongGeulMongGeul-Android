package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.LocalStorage
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostImageResponse
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostTogetherRequest
import okhttp3.MultipartBody
import retrofit2.Response

class PostDataSource(private val postApi: PostApi, private val localStorage: LocalStorage) {

    suspend fun postImage(image: MultipartBody.Part): Response<PostImageResponse> =
           postApi.postImage(image)

    suspend fun post(postRequest: PostRequest): Response<Unit> =
        postApi.post(localStorage.getToken(), postRequest)

    suspend fun postTogether(request: PostTogetherRequest) =
        postApi.postGroup(localStorage.getToken(), request)
}