package com.okifwant.donggeulmonggeul_android.viewmodel.post

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(): BaseViewModel() {

    val title = MutableLiveData<String>()

    val category = MutableLiveData("카테고리")

    val body = MutableLiveData<String>()

    val imageUri = MutableLiveData<Uri>()

    val categoryIndex = MutableLiveData<Int>()

    private val _clickEvent = MutableEventFlow<ClickEvent.CategoryClick>()
    val clickEvent = _clickEvent.asEventFlow()

    fun onClickEvent(event: ClickEvent.CategoryClick) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun categoryClicked(index: Int) {
        categoryIndex.value = index
        onClickEvent(ClickEvent.CategoryClick)
    }

    sealed class ClickEvent{
        object CategoryClick : ClickEvent()
    }
}