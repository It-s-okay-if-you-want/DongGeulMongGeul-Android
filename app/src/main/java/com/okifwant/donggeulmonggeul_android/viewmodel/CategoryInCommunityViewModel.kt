package com.okifwant.donggeulmonggeul_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.data.api.CategoryApi
import com.okifwant.donggeulmonggeul_android.data.model.category.Data
import com.okifwant.donggeulmonggeul_android.data.model.category.GetPostCategory
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import com.okifwant.donggeulmonggeul_android.widget.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CategoryInCommunityViewModel @Inject constructor(
    val categoryApi : CategoryApi,
    val localStorage: LocalStorage
): ViewModel() {

    val apiErrorEvent: LiveData<Any> get() = _apiErrorEvent
    private val _apiErrorEvent = SingleLiveEvent<Any>()

    val apiNullEvent: LiveData<Any> get() = _apiNullEvent
    private val _apiNullEvent = SingleLiveEvent<Any>()

    val getCategoryResponse: LiveData<Response<GetPostCategory>> get() = _getCategoryResponse
    private val _getCategoryResponse = SingleLiveEvent<Response<GetPostCategory>>()

    var getPostCategoryList = arrayListOf<Data>()
    var choiceCategory = 1

    val clickedPost = SingleLiveEvent<Int>()

    fun getPostCategory(category : Int) = viewModelScope.launch {
        try {
            categoryApi.getPostCategory(localStorage.getToken(), category).let {
                if (it.isSuccessful){
                    if (!it.body()?.data.isNullOrEmpty()){
                        for (item in 0 until it.body()?.data?.size!!){
                            var question = it.body()?.data!![item]
                            getPostCategoryList.add(question)
                        }
                        _getCategoryResponse.postValue(it)

                    }else{
                        _apiNullEvent.call()
                    }

                }else{
                    _apiErrorEvent.call()
                }
            }
        }catch (e: Exception){
            _apiErrorEvent.call()
        }
    }
}