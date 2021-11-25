package com.okifwant.donggeulmonggeul_android.ui

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.tutorial.PagerRecyclerAdapter
import com.okifwant.donggeulmonggeul_android.base.BaseFragment
import com.okifwant.donggeulmonggeul_android.base.SangSunBaseFragment
import com.okifwant.donggeulmonggeul_android.databinding.FragmentTutorialMainBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.TutorialViewModel


class TutorialMainFragment :
    SangSunBaseFragment<FragmentTutorialMainBinding>(R.layout.fragment_tutorial_main) {
    private val viewModel by activityViewModels<TutorialViewModel>()

    override fun init() {
        initViewPager()
        observeViewModel()
    }

    private fun initViewPager() {
        binding.viewPager2.adapter = PagerRecyclerAdapter(viewModel)
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.setViewPager2(binding.viewPager2)
    }

    private fun observeViewModel() {
    /*    viewModel.startBtnEvent.observe(this, { page ->
            Log.d("TAG", "page info : $page")
            *//* when (page) {
                 3 -> binding.startBtn.visibility = View.VISIBLE
                 else -> binding.startBtn.visibility = View.INVISIBLE
             }*//*
        })*/
    }
}