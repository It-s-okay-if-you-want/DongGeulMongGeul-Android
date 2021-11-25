package com.okifwant.donggeulmonggeul_android.viewmodel

import androidx.lifecycle.LiveData
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.widget.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialViewModel @Inject constructor() : BaseViewModel() {
    val startBtnEvent: LiveData<Int> get() = _startBtnEvent
    private val _startBtnEvent = SingleLiveEvent<Int>()

    fun setStartBtnClickEvent() = _startBtnEvent.call()
}