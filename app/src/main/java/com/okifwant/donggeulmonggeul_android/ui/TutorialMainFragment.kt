package com.okifwant.donggeulmonggeul_android.ui

import androidx.viewpager2.widget.ViewPager2
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.tutorial.PagerRecyclerAdapter
import com.okifwant.donggeulmonggeul_android.base.BaseFragment
import com.okifwant.donggeulmonggeul_android.databinding.FragmentTutorialMainBinding


class TutorialMainFragment : BaseFragment<FragmentTutorialMainBinding>(R.layout.fragment_tutorial_main) {
    override fun init() {
        initViewPager()
    }

    private fun initViewPager(){
        binding.viewPager2.adapter = PagerRecyclerAdapter()
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.setViewPager2(binding.viewPager2)
    }
}