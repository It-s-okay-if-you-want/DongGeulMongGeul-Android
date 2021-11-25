package com.okifwant.donggeulmonggeul_android.viewmodel.post

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.SingleLiveEvent
import com.okifwant.donggeulmonggeul_android.data.post.PostDataSource
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostTogetherRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class PostTogetherViewModel @Inject constructor(private val postDataSource: PostDataSource) :
    BaseViewModel() {
    val title = MutableLiveData<String>()

    val category = MutableLiveData("카테고리")

    val body = MutableLiveData<String>()

    val imageUri = MutableLiveData<Uri>()

    val date = MutableLiveData<String>()

    val imageString = MutableLiveData<String>()

    val categoryIndex = MutableLiveData<Int>()

    val done = SingleLiveEvent<Unit>()
    fun post() {
        viewModelScope.launch {
            val response = postDataSource.postTogether(
                PostTogetherRequest(
                    title = title.value ?: "",
                    category = (categoryIndex.value ?: 0) + 1,
                    date = date.value ?: "",
                    content = body.value ?: "",
                    image = imageString.value ?: ""
                )
            )
            if (response.isSuccessful) {
                done.call()
            }
        }
    }

    fun postImage(image: MultipartBody.Part) {
        viewModelScope.launch {
            val response = postDataSource.postImage(image)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    imageString.value = response.body()!!.data.files[0]
                }
            }
        }

    }
}