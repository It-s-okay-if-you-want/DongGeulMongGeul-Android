package com.okifwant.donggeulmonggeul_android.viewmodel.post

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.SingleLiveEvent
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import com.okifwant.donggeulmonggeul_android.data.post.PostDataSource
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postDataSource: PostDataSource) :
    BaseViewModel() {

    val title = MutableLiveData<String>()

    val category = MutableLiveData("카테고리")

    val body = MutableLiveData<String>()

    val imageUri = MutableLiveData<Uri>()

    val imageString = MutableLiveData<String>()

    val categoryIndex = MutableLiveData<Int>()

    private val _clickEvent = MutableEventFlow<ClickEvent.CategoryClick>()
    val clickEvent = _clickEvent.asEventFlow()

    val message = SingleLiveEvent<String>()

    val done = SingleLiveEvent<Unit>()

    fun onClickEvent(event: ClickEvent.CategoryClick) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun categoryClicked(index: Int) {
        categoryIndex.value = index
        onClickEvent(ClickEvent.CategoryClick)
    }

    sealed class ClickEvent {
        object CategoryClick : ClickEvent()
    }

    fun postImage(image: MultipartBody.Part) {
        viewModelScope.launch {
            val response = postDataSource.postImage(image)
            if(response.isSuccessful) {
                if(response.body() != null) {
                    imageString.value = response.body()!!.data.files[0]
                }
            }
        }

    }

    fun post() {
        viewModelScope.launch {
            val response = postDataSource.post(
                PostRequest(
                    title.value ?: "",
                    category = (categoryIndex.value ?: 0) + 1,
                    content = body.value ?: "",
                    image = imageString.value ?: ""
                )
            )
            if(response.isSuccessful) {
                message.value = "게시되었습니다"
                done.call()
            }
        }

    }
}