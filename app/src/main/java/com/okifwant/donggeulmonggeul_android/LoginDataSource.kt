package com.okifwant.donggeulmonggeul_android

import com.okifwant.donggeulmonggeul_android.dto.LoginRequest
import com.okifwant.donggeulmonggeul_android.dto.LoginResponse
import com.okifwant.donggeulmonggeul_android.dto.RegisterRequest
import com.okifwant.donggeulmonggeul_android.dto.RegisterResponse
import com.okifwant.donggeulmonggeul_android.remote.LoginApi
import retrofit2.Response

class LoginDataSource(private val loginApi : LoginApi) {

    suspend fun register(registerRequest: RegisterRequest) : Response<RegisterResponse> =
        loginApi.register(registerRequest)

    suspend fun login(loginRequest: LoginRequest) : Response<LoginResponse> =
        loginApi.login(loginRequest)
}