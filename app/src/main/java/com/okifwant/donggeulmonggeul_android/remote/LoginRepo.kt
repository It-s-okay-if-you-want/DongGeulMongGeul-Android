package com.okifwant.donggeulmonggeul_android.remote

import com.okifwant.donggeulmonggeul_android.di.ApiModule
import com.okifwant.donggeulmonggeul_android.dto.LoginRequest
import com.okifwant.donggeulmonggeul_android.dto.LoginResponse
import com.okifwant.donggeulmonggeul_android.dto.RegisterRequest
import com.okifwant.donggeulmonggeul_android.dto.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginApi {
    @POST("/auth/register")
    suspend fun register(
        @Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest): Response<LoginResponse>


}