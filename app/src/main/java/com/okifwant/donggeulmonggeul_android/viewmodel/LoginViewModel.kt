package com.okifwant.donggeulmonggeul_android.viewmodel

import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.LoginDataSource
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import com.okifwant.donggeulmonggeul_android.dto.LoginRequest
import com.okifwant.donggeulmonggeul_android.dto.LoginResponse
import com.okifwant.donggeulmonggeul_android.pref.LocalStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataSource : LoginDataSource,
    private val localStorage: LocalStorage
) : BaseViewModel() {

    private val _clickEvent = MutableEventFlow<ClickEvent>()
    val clickEvent = _clickEvent.asEventFlow()

    fun onClickEvent(event: ClickEvent) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun signUpClick(){
        onClickEvent(ClickEvent.SignUpClick)
    }

    fun login(login : LoginRequest){
        viewModelScope.launch {
            val response = dataSource.login(login)
            if(response.isSuccessful){
                println(login)
                if(response.body() != null) {
                    localStorage.saveRefreshToken(response.body()!!.data.token)
                    localStorage.saveToken(response.body()!!.data.refreshToken)
                    userToken = response.body()!!.data.token
                    onClickEvent(ClickEvent.Login(response.body()!!))
                }

            }
        }
    }

    sealed class ClickEvent {
        object SignUpClick : ClickEvent()
        data class Login(val data : LoginResponse) : ClickEvent()
    }

    companion object{
        var userToken = ""
    }


}