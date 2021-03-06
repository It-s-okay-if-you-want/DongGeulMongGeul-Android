package com.okifwant.donggeulmonggeul_android.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.DialogSubSubBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostDetailViewModel

class SubSubDialog(private val viewModel: PostDetailViewModel, private val isPost: Boolean): DialogFragment() {
    lateinit var binding: DialogSubSubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_sub_sub, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.run {
            editBtn.setOnClickListener {
                if(isPost) {
                    viewModel.startEditPost.value = viewModel.postId
                }
            }

            deleteBtn.setOnClickListener {
                if(isPost) {
                    viewModel.deletePost()
                }
            }

            reportBtn.setOnClickListener {
                if(isPost) {
                    viewModel.reportPost()
                } else {
                    viewModel.reportComment()
                }
            }
        }
    }

}