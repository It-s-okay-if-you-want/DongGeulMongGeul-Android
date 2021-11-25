package com.okifwant.donggeulmonggeul_android.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.DialogCategoryPostBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel

class PostCategoryDialog(private val vm: PostViewModel): BottomSheetDialogFragment() {
    private lateinit var binding: DialogCategoryPostBinding

    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_category_post, container, false)
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
            categoryIndex.observe(viewLifecycleOwner, {
                category.value =
                    when(it) {
                        0 -> "기뻐요"
                        1 -> "웃겨요"
                        2 -> "슬퍼요"
                        3 -> "무서워요"
                        4 -> "여기에요"
                        5 -> "조심해요"
                        6 -> "추천해요"
                        else -> "카테고리"
                    }
            })
        }
    }
}