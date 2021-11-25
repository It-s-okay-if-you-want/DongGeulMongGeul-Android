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

    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InRlc3QiLCJpYXQiOjE2Mzc4Mjc4NzMsImV4cCI6MTYzNzkxNDI3Mywic3ViIjoidG9rZW4ifQ.rl617JAF1OsqnkQYoAl7wjrg5SDW8JTV0FbNc04X8To"
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

                    viewModel.getAuth(token)
                }

            }
        }
    }

    fun getPoPAndNewPost(){
        lifecycleScope.launch{

            with(viewModel){

                lifecycleScope.launch {

                    viewModel.getPoPAndNewPost(token)
                }

            }
        }
    }

    fun setNewPop(){

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.newViewpager.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        binding.newViewpager.adapter = MainNewAdapter(this,newList())
        binding.newViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.popularityViewpager.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
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