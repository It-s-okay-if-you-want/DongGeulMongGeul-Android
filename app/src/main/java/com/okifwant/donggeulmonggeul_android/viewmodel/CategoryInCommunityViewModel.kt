package com.okifwant.donggeulmonggeul_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.data.api.CategoryApi
import com.okifwant.donggeulmonggeul_android.data.model.category.GetPostCategory
import com.okifwant.donggeulmonggeul_android.widget.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CategoryInCommunityViewModel @Inject constructor(
    val categoryApi : CategoryApi
): ViewModel() {

    val apiErrorEvent: LiveData<Any> get() = _apiErrorEvent
    private val _apiErrorEvent = SingleLiveEvent<Any>()

    val getCategoryResponse: LiveData<Response<GetPostCategory>> get() = _getCategoryResponse
    private val _getCategoryResponse = SingleLiveEvent<Response<GetPostCategory>>()

    val testToken  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InF3ZXIxMjM0IiwiaWF0IjoxNjM3ODMwMDY5LCJleHAiOjE2Mzc5MTY0NjksInN1YiI6InRva2VuIn0.T10cPT7ia7a-PfnIzMrd8ceRiOlKzhrY7CDPx11UhfI"

    fun getPostCategory(category : Int) = viewModelScope.launch {
        try {
            categoryApi.getPostCategory(testToken, category).let {
                if (it.isSuccessful){
                    _getCategoryResponse.postValue(it)
                }else{
                    _apiErrorEvent.call()
                }
            }
        }catch (e: Exception){
            _apiErrorEvent.call()
        }
    }
}