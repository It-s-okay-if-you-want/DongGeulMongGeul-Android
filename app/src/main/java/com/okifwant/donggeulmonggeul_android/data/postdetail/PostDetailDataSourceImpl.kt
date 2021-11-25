package com.okifwant.donggeulmonggeul_android.data.postdetail

import com.okifwant.donggeulmonggeul_android.data.api.PostDetailApi
import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import com.okifwant.donggeulmonggeul_android.dto.PutPostDetailRequest
import retrofit2.Response


class PostDetailDataSourceImpl(private val postDetailApi : PostDetailApi): PostDetailDataSource {
    override suspend fun getPostDetail(id: Int): Response<PostDetailResponse> =
        postDetailApi.getPostDetail(id)

    override suspend fun deletePostDetail(id: Int): Response<Unit> =
        postDetailApi.deletePostDetail(id)

    override suspend fun putPostDetail(id: Int, postDetail: PutPostDetailRequest): Response<Unit> =
        putPostDetail(id,postDetail)

}