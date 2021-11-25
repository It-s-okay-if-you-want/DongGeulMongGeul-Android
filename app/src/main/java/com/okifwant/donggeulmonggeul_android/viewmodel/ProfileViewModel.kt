package com.okifwant.donggeulmonggeul_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.Event
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import com.okifwant.donggeulmonggeul_android.data.post.PostDataSource
import com.okifwant.donggeulmonggeul_android.data.post.ProfileApi
import com.okifwant.donggeulmonggeul_android.data.post.dto.PostRequest
import com.okifwant.donggeulmonggeul_android.dto.ProfileUpdate
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileApi : ProfileApi
    ) : BaseViewModel() {

    private val _isSuccess = MutableLiveData<Event<Boolean>>()
    val isSuccess: LiveData<Event<Boolean>> get() = _isSuccess

    private val _clickEvent = MutableEventFlow<ClickEvent.CategoryClick>()
    val clickEvent = _clickEvent.asEventFlow()

    val local = MutableLiveData("지역")

    val dog = MutableLiveData("동네")

    val userLocal =  MutableLiveData<String>()

    val userNick = MutableLiveData<String>()

    val dogList: MutableList<String> = mutableListOf("1","2","3","4","5","6","7")

    val localIndex = MutableLiveData<Int>()

    val dogIndex = MutableLiveData<Int>()

    sealed class ClickEvent {
        object CategoryClick : ClickEvent()
    }

    fun onClickEvent(event: ProfileViewModel.ClickEvent.CategoryClick) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun categoryClicked(index: Int) {
        localIndex.value = index
        onClickEvent(ClickEvent.CategoryClick)
    }

    suspend fun editProfile(token : String, nickname : String){

        try {
            profileApi.profileEdit(token,ProfileUpdate(nickname,"$local" + "$dog")).let {
                _isSuccess.value = Event(true)

                Log.d("is susses Auth","$it")

            }
        }
        catch (e: Exception) {
            Log.d("error", "fail to : $e")

            _isSuccess.value = Event(false)
        }
        }

    fun dogClicked(index: Int){
        dogIndex.value = index
        onClickEvent(ClickEvent.CategoryClick)
    }
}