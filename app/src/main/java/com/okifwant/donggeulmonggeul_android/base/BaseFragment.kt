package com.okifwant.donggeulmonggeul_android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.okifwant.donggeulmonggeul_android.BR

abstract class BaseFragment<T: ViewDataBinding, R: BaseViewModel>: Fragment() {
    lateinit var binding: T

    abstract val layoutId: Int
    abstract val viewModel: R

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.vm, viewModel)
        requireActivity().onBackPressedDispatcher.addCallback {
            onBackPressed()
        }
        init()
    }

    open fun init() {

    }

    open fun onBackPressed() {
    }
}