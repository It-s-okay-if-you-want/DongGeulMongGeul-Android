package com.okifwant.donggeulmonggeul_android.viewmodel.post

import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.data.postdetail.PostDetailDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postDetailDataSource: PostDetailDataSource): BaseViewModel() {

}