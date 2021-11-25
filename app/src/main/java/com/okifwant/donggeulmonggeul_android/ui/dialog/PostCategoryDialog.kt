package com.okifwant.donggeulmonggeul_android.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.okifwant.donggeulmonggeul_android.databinding.DialogCategoryPostBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel

class PostCategoryDialog(private val vm: PostViewModel): BottomSheetDialogFragment() {
    private lateinit var binding: DialogCategoryPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogCategoryPostBinding.inflate(LayoutInflater.from(context))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}