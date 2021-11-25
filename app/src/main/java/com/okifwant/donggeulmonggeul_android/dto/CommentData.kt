package com.okifwant.donggeulmonggeul_android.dto

data class CommentData(
    val idx : String,
    val content : String,
    val createdAt : String,
    val postIdx : String,
    val groupIdx : String,
    val userId : String,
    val commentReport : List<CommentReportData>
)