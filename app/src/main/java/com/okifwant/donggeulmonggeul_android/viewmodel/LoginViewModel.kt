package com.okifwant.donggeulmonggeul_android.viewmodel

import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
        object SignUpClick() : ClickEvent
    }

}