package com.okifwant.donggeulmonggeul_android.pref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefStorage(val context: Context) : LocalStorage {

    private val tokenKey = "tokenKey"

    private val refreshTokenKey = "refreshTokenKey"


    override fun saveToken(token: String) =
        getPref(context).edit().let {
            it.putString(tokenKey, token)
            it.apply()
        }

    override fun getToken(): String =
        getPref(context).getString(tokenKey, "").toString()


    override fun saveRefreshToken(token: String) =
        getPref(context).edit().let {
            it.putString(refreshTokenKey, token)
            it.apply()
        }

    override fun getRefreshToken()  =
        getPref(context).getString(refreshTokenKey, "").toString()

    private fun getPref(context: Context): SharedPreferences =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE)

}