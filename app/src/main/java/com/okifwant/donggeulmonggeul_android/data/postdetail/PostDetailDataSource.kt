package com.okifwant.donggeulmonggeul_android.data.postdetail

import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import retrofit2.Response

interface PostDetailDataSource {
    suspend fun getPostDetail(id: Int): Response<PostDetailResponse>
}