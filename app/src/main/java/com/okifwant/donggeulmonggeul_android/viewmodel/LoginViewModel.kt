package com.okifwant.donggeulmonggeul_android.viewmodel

import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.MutableEventFlow
import com.okifwant.donggeulmonggeul_android.base.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val _clickEvent = MutableEventFlow<ClickEvent>()
    val clickEvent = _clickEvent.asEventFlow()

    fun onClickEvent(event: ClickEvent) {
        viewModelScope.launch { _clickEvent.emit(event) }
    }

    fun signUpClick(){
        onClickEvent(ClickEvent.SignUpClick)
    }

    sealed class ClickEvent {
        object SignUpClick : ClickEvent()
    }

}