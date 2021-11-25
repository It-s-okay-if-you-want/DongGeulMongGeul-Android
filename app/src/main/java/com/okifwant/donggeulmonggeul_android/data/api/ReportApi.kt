package com.okifwant.donggeulmonggeul_android.data.api

import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ReportApi {
    @POST("report/post/{idx}")
    suspend fun reportPost(@Header("Authorization") token: String, @Path("idx") id: Int): Response<Unit>

    @POST("report/comment/{idx}")
    suspend fun reportComment(@Header("Authorization") token: String, @Path("idx") id: Int): Response<Unit>

}