package com.okifwant.donggeulmonggeul_android.viewmodel.post

import androidx.lifecycle.MutableLiveData
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel

class PostViewModel: BaseViewModel() {

    val title = MutableLiveData<String>()

    val category = MutableLiveData("카테고리")

    val body = MutableLiveData<String>()

}