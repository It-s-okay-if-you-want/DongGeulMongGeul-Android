package com.okifwant.donggeulmonggeul_android.ui.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.DialogCategoryPostBinding
import com.okifwant.donggeulmonggeul_android.databinding.DialogProfileBinding
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.viewmodel.ProfileViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel
import kotlinx.coroutines.flow.collect

class ProfileDialog(private val vm: ProfileViewModel) : BottomSheetDialogFragment() {
    private lateinit var binding: DialogProfileBinding

    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        observeEvent()
    }

    private fun observeEvent() {
        vm.run {
            localIndex.observe(viewLifecycleOwner, {
                local.value =
                    when (it) {
                        0 -> "서울"
                        1 -> "대구"
                        2 -> "대전"
                        3 -> "인천"
                        4 -> "광주"
                        5 -> "부산"
                        6 -> "강릉"
                        else -> "기타"
                    }
            })
        }
        repeatOnStarted {
            vm.clickEvent.collect {
                when (it) {
                    is ProfileViewModel.ClickEvent.CategoryClick -> {
                        dismiss()
                    }
                }

            }
        }
    }
}