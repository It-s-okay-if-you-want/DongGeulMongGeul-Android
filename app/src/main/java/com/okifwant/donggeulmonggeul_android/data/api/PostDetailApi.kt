package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import com.okifwant.donggeulmonggeul_android.dto.PutPostDetailRequest
import retrofit2.Response
import retrofit2.http.*

interface PostDetailApi {

    @GET("/post/{idx}")
    fun getPostDetail(
        @Path("idx") id : Int
    ) : Response<PostDetailResponse>

    @DELETE("/post/{idx}")
    fun deletePostDetail(
        @Path("idx") id : Int
    ) : Response<Unit>


    @PUT("/post/{idx}")
    fun putPostDetail(
        @Path("idx") id : Int,
        @Body putPostDetail : PutPostDetailRequest
    ) : Response<Unit>



}