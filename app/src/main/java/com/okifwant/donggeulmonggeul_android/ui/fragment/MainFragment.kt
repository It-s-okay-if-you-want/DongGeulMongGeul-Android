package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.MainNewAdapter
import com.okifwant.donggeulmonggeul_android.adapter.MainPopAdapter
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Data
import com.okifwant.donggeulmonggeul_android.databinding.FragmentMainBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        getPoPAndNewPost()

        getAuth()

        viewModel.data.observe(viewLifecycleOwner){
            setNewPop()
        }
        viewModel.data.observe(viewLifecycleOwner){
            popList()
        }

        viewModel.auth.observe(viewLifecycleOwner){
            binding.text = it
        }


        return binding.root
    }

    fun getAuth(){
        lifecycleScope.launch{

            with(viewModel){

                lifecycleScope.launch {
                    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InF3ZXIxMjM0IiwiaWF0IjoxNjM3ODU5NjM2LCJleHAiOjE2Mzc5NDYwMzYsInN1YiI6InRva2VuIn0.lKdKm3fFORLpXsNw8S3_uJZx8kmxy1n72dQ5_udjsGk"

                    viewModel.getAuth(token)
                }

            }
        }
    }

    fun getPoPAndNewPost(){
        lifecycleScope.launch{

            with(viewModel){

                lifecycleScope.launch {

                    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InF3ZXIxMjM0IiwiaWF0IjoxNjM3ODU5NjM2LCJleHAiOjE2Mzc5NDYwMzYsInN1YiI6InRva2VuIn0.lKdKm3fFORLpXsNw8S3_uJZx8kmxy1n72dQ5_udjsGk"
                    viewModel.getPoPAndNewPost(token)
                }

            }
        }
    }

    fun setNewPop(){

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen ?????? ?????? ????????? ??????????????????.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen ????????? ????????? ???????????????
        val screenWidth = resources.displayMetrics.widthPixels // ??????????????? ?????? ????????? ?????????
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.newViewpager.offscreenPageLimit = 1 // ??? ?????? ???????????? ?????? ?????? ???????????????
        binding.newViewpager.adapter = MainNewAdapter(this,newList())
        binding.newViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.popularityViewpager.offscreenPageLimit = 1 // ??? ?????? ???????????? ?????? ?????? ???????????????
        binding.popularityViewpager.adapter = MainPopAdapter(this,newList())
        binding.popularityViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.popularityViewpager.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }
    }

    fun popList() : List<Data>?{
        return viewModel.popData.value?.data?.toList()
    }

    fun newList(): List<Data>? {
        return viewModel.data.value?.data?.toList()
    }

}