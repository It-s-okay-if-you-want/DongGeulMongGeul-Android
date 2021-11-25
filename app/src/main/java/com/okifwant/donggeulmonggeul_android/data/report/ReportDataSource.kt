package com.okifwant.donggeulmonggeul_android.data.report

import retrofit2.Response

interface ReportDataSource {
    suspend fun reportPost(id: Int): Response<Unit>
}