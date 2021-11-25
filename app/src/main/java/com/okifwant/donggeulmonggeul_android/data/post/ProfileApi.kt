package com.okifwant.donggeulmonggeul_android.data.post

import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import com.okifwant.donggeulmonggeul_android.dto.ProfileResponse
import com.okifwant.donggeulmonggeul_android.dto.ProfileUpdate
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ProfileApi {

    @POST("/auth/edit")
    suspend fun profileEdit(@Header("Authorization") token: String, @Body request: ProfileUpdate): ProfileResponse
}