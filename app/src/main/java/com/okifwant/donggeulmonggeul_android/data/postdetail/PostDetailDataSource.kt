package com.okifwant.donggeulmonggeul_android.data.postdetail

import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import com.okifwant.donggeulmonggeul_android.dto.PutPostDetailRequest
import retrofit2.Response

interface PostDetailDataSource {
    suspend fun getPostDetail(id: Int): Response<PostDetailResponse>

    suspend fun deletePostDetail(id : Int) : Response<Unit>

    suspend fun putPostDetail(id : Int, postDetail : PutPostDetailRequest) : Response<Unit>

    suspend fun postComment(message: String) : Response<Unit>
}