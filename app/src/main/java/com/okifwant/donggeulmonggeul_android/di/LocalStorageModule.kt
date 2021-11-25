package com.okifwant.donggeulmonggeul_android.di

import android.content.Context
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import com.okifwant.donggeulmonggeul_android.pref.SharedPrefStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Singleton
    @Provides
    fun provideSharedPrefStorage(@ApplicationContext context: Context) : LocalStorage {
        return SharedPrefStorage(context = context)
    }
}