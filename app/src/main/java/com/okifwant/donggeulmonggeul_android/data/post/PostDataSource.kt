package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.post.dto.PostImageResponse
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostTogetherRequest
import okhttp3.MultipartBody
import retrofit2.Response

class PostDataSource(private val postApi: PostApi) {

    suspend fun postImage(image: MultipartBody.Part): Response<PostImageResponse> =
           postApi.postImage(image)

    //TODO 토큰 얻어와서 넣기
    suspend fun post(postRequest: PostRequest): Response<Unit> =
        postApi.post("todo-토큰넣어야해", postRequest)

    suspend fun postTogether(request: PostTogetherRequest) =
        postApi.postGroup("todo-토큰넣어야", request)
}