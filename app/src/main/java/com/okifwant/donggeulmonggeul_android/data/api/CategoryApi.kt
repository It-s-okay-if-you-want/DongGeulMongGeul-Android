package com.okifwant.donggeulmonggeul_android.data.api

import com.okifwant.donggeulmonggeul_android.data.model.category.GetPostCategory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryApi {
    @GET("post/category/{category}")
    suspend fun getPostCategory(
        @Header("Authorization") Authorization: String,
        @Path("category") category: Int
    ) : Response<GetPostCategory>
}