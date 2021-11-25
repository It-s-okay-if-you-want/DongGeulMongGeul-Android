package com.okifwant.donggeulmonggeul_android.viewmodel

import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.LoginDataSource
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import com.okifwant.donggeulmonggeul_android.dto.LoginRequest
import com.okifwant.donggeulmonggeul_android.dto.RegisterRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(val dataSource: LoginDataSource): BaseViewModel() {

    private val _clickEvent = MutableEventFlow<LoginViewModel.ClickEvent>()
    val clickEvent = _clickEvent.asEventFlow()

    fun onClickEvent(event: LoginViewModel.ClickEvent) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun signUpClick(){
        onClickEvent(LoginViewModel.ClickEvent.SignUpClick)
    }

    fun register(register : RegisterRequest){
        viewModelScope.launch {
            val response = dataSource.register(register)
            if(response.isSuccessful){
                println(response)
            }
        }
    }

}