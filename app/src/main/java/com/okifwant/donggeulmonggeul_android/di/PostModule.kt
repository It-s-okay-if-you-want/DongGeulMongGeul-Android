package com.okifwant.donggeulmonggeul_android.di

import com.okifwant.donggeulmonggeul_android.data.post.PostApi
import com.okifwant.donggeulmonggeul_android.data.post.PostDataSource
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @Singleton
    @Provides
    fun providePostDataSource(postApi: PostApi, localStorage: LocalStorage): PostDataSource = PostDataSource(postApi, localStorage)

    @Singleton
    @Provides
    fun providePostData(retrofit: Retrofit): PostApi = retrofit.create(PostApi::class.java)
}