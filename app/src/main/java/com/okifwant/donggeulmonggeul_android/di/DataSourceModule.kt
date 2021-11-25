package com.okifwant.donggeulmonggeul_android.di

import com.okifwant.donggeulmonggeul_android.LoginDataSource
import com.okifwant.donggeulmonggeul_android.remote.LoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideLoginDataSource(loginApi : LoginApi) : LoginDataSource = LoginDataSource(loginApi)

    @Singleton
    @Provides
    fun provideLogin(retrofit : Retrofit) : LoginApi = retrofit.create(LoginApi::class.java)
}