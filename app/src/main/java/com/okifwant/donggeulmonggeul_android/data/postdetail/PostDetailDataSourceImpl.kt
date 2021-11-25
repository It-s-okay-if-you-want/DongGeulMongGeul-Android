package com.okifwant.donggeulmonggeul_android.data.postdetail

import com.okifwant.donggeulmonggeul_android.data.api.CommentApi
import com.okifwant.donggeulmonggeul_android.data.api.PostDetailApi
import com.okifwant.donggeulmonggeul_android.dto.CommentRequest
import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import com.okifwant.donggeulmonggeul_android.dto.PutPostDetailRequest
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import retrofit2.Response


class PostDetailDataSourceImpl(private val postDetailApi : PostDetailApi, private val commentApi: CommentApi, private val localStorage: LocalStorage): PostDetailDataSource {
    override suspend fun getPostDetail(id: Int): Response<PostDetailResponse> =
        postDetailApi.getPostDetail(id,localStorage.getToken())

    override suspend fun deletePostDetail(id: Int): Response<Unit> =
        postDetailApi.deletePostDetail(id,localStorage.getToken())

    override suspend fun putPostDetail(id: Int, postDetail: PutPostDetailRequest): Response<Unit> =
        postDetailApi.putPostDetail(id,postDetail,localStorage.getToken())

    override suspend fun postComment(id: Int, message: String): Response<Unit> =
        commentApi.postComment(id, localStorage.getToken(), CommentRequest(message))

}