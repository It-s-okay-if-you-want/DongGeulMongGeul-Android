package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.dto.PostDetailResponse
import com.okifwant.donggeulmonggeul_android.dto.PutPostDetailRequest
import retrofit2.Response
import retrofit2.http.*

interface PostDetailApi {

    @GET("/post/{idx}")
    suspend fun getPostDetail(
        @Path("idx") id : Int,
        @Header("Authorization") token : String
    ) : Response<PostDetailResponse>

    @DELETE("/post/{idx}")
    suspend fun deletePostDetail(
        @Path("idx") id : Int,
        @Header("Authorization") token : String
    ) : Response<Unit>


    @PUT("/post/{idx}")
    suspend fun putPostDetail(
        @Path("idx") id : Int,
        @Body putPostDetail : PutPostDetailRequest,
        @Header("Authorization") token : String
    ) : Response<Unit>



}