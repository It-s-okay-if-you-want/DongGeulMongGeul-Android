package com.okifwant.donggeulmonggeul_android.pref


interface LocalStorage {

    fun saveToken(token : String)

    fun getToken() : String

    fun saveRefreshToken(token : String)

    fun getRefreshToken() : String
}