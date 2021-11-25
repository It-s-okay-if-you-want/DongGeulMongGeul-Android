package com.okifwant.donggeulmonggeul_android.di

import com.okifwant.donggeulmonggeul_android.data.api.CommentApi
import com.okifwant.donggeulmonggeul_android.data.api.PostDetailApi
import com.okifwant.donggeulmonggeul_android.data.postdetail.PostDetailDataSource
import com.okifwant.donggeulmonggeul_android.data.postdetail.PostDetailDataSourceImpl
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostDetailModule {

    @Singleton
    @Provides
    fun providePostDetailDataSource(
        postDetailApi: PostDetailApi,
        localStorage: LocalStorage
    ): PostDetailDataSource = PostDetailDataSourceImpl(postDetailApi, localStorage)

    @Singleton
    @Provides
    fun provideCommentApi(retrofit: Retrofit): CommentApi = retrofit.create(CommentApi::class.java)
}