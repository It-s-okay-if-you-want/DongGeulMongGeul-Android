package com.okifwant.donggeulmonggeul_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.data.api.PostService
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.Event
import com.okifwant.donggeulmonggeul_android.data.model.auth.Auth
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Data
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val service : PostService
) : BaseViewModel(){

    private val TAG = "MainLog"

    private val _isSuccess = MutableLiveData<Event<Boolean>>()
    val isSuccess: LiveData<Event<Boolean>> get() = _isSuccess

    private val _categort = MutableLiveData<List<Data>>()
    val categort: LiveData<List<Data>> get() = _categort

    private val _popData = MutableLiveData<Post>()
    val popData: LiveData<Post> get() = _popData

    private val _auth = MutableLiveData<Auth>()
    val auth: LiveData<Auth> get() = _auth

    private val _data = MutableLiveData<Post>()
    val data: LiveData<Post> get() = _data

    suspend fun getPoPAndNewPost(token : String) = viewModelScope.launch {

        try {
            service.viewTest(token).let {
                _isSuccess.value = Event(true)

                Log.d("is susses","$it")
                _data.value = it

            }
            service.viewPop(token).let {
                _isSuccess.value = Event(true)

                Log.d("is susses pop","$it")
                _popData.value = it
            }
          }
             catch (e: Exception) {
                 Log.d(TAG, "fail to : $e")

                 _isSuccess.value = Event(false)
             }
         }

    suspend fun getAuth(token: String) = viewModelScope.launch {
        try {
            service.viewAuth(token).let {
                _isSuccess.value = Event(true)

                Log.d("is susses Auth","$it")

                _auth.value = it

            }
        }
        catch (e: Exception) {
            Log.d(TAG, "fail to : $e")

            _isSuccess.value = Event(false)
        }
    }
}