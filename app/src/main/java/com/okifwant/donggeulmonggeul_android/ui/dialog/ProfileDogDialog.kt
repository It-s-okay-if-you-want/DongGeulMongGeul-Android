package com.okifwant.donggeulmonggeul_android.ui.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.DialogProfileBinding
import com.okifwant.donggeulmonggeul_android.databinding.DialogProfileDogBinding
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.viewmodel.ProfileViewModel
import kotlinx.coroutines.flow.collect

class ProfileDogDialog(private val vm : ProfileViewModel) : BottomSheetDialogFragment() {
    private lateinit var binding: DialogProfileDogBinding

    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_profile_dog, container, false)
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
            when(local.value){
                "서울" -> {

                    val mulist: MutableList<String> = mutableListOf<String>("중구", "종로", "서대문", "마포", "성동","광진","용산")

                    dogList.addAll(0,mulist)

                    when (dogIndex.value) {
                        0 -> {
                            dog.value =  "중구"}
                        1 -> {
                            dog.value =  "종로"
                            }
                        2 -> {dog.value = "서대문"
                        }
                        3 -> {dog.value ="마포"}
                        4 -> {dog.value ="성동"}
                        5 ->{dog.value ="광진"}
                        6 -> {dog.value ="용산"}
                        else -> "기타"
                    }
                }
                "대구" ->   {
                    val mulist: MutableList<String> = mutableListOf<String>("동구", "북구", "서구", "중구", "수성구","당성군","기타")

                    dogList.addAll(0,mulist)
                    dog.value
                    when (dogIndex.value) {
                        0 -> {
                            dog.value ="동구"}
                        1 -> {
                            dog.value = "북구"}
                        2 -> {dog.value ="서구"
                        }
                        3 -> {dog.value ="중구"}
                        4 -> {dog.value ="수성구"}
                        5 ->{dog.value = "당성군"}
                        6 -> {dog.value ="기타"}
                        else -> "기타"
                    }
                }
                "대전" ->  {

                    val mulist: MutableList<String> = mutableListOf<String>("유성구", "대덕구", "회덕동", "동구", "대화동","오정동","기타")

                    dogList.addAll(0,mulist)

                    dog.value
                    when (dogIndex.value) {
                        0 -> {
                            dog.value ="유성구"}
                        1 -> {
                            dog.value ="대덕구"}
                        2 -> {dog.value ="회덕동"
                        }
                        3 -> {dog.value ="동구"}

                        4 -> {dog.value ="대화동"}
                        5 ->{dog.value ="오정동"}
                        6 -> {dog.value ="기타"}
                        else -> "기타"
                    }
                }
                "인천" ->   {
                    dog.value

                    val mulist: MutableList<String> = mutableListOf<String>("계양구", "서구", "부평구", "남동구", "중구","연수구","미추홀구")

                    dogList.addAll(0,mulist)

                    when (dogIndex.value) {
                        0 -> {
                            dog.value ="계양구"}
                        1 -> {
                            dog.value ="서구"}
                        2 -> {dog.value ="부평구"
                        }
                        3 -> {dog.value ="남동구"}
                        4 -> {dog.value ="중구"}
                        5 ->{dog.value ="연수구"}
                        6 -> {dog.value ="미추홀구"}
                        else -> "기타"
                    }
                }
                "광주" ->
                {

                        val mulist: MutableList<String> = mutableListOf<String>("북구", "남구", "동구", "서구", "광산구","기타")

                        dogList.addAll(0,mulist)

                        dog.value
                        when (dogIndex.value) {
                            0 -> {
                                dog.value ="북구"}
                            1 -> {
                                dog.value = "남구"}
                            2 -> {dog.value ="동구"
                            }
                            3 -> {dog.value ="서구"}
                            4 -> {dog.value ="광산구"}
                            5 -> {dog.value ="기타"}
                            else -> "기타"
                        }
                    }
                "부산" ->   {

                    val mulist: MutableList<String> = mutableListOf<String>("금정구", "중구", "서구", "남구", "부산진구","영도구")

                    dogList.addAll(0,mulist)

                    dog.value
                    when (dogIndex.value) {
                        0 -> {
                            dog.value ="금정구"}
                        1 -> {
                            dog.value ="중구"}
                        2 -> {dog.value ="서구"
                        }
                        3 -> {dog.value ="남구"}
                        4 -> {dog.value ="부산진구"}
                        5 ->{dog.value ="영도구"}
                        6 -> {dog.value ="기타"}
                        else -> "기타"
                    }
                }

                "강릉" ->  {


                    val mulist: MutableList<String> = mutableListOf<String>("시내동지구", "구정면", "강동면", "사천면", "연곡면","기타")

                    dogList.addAll(0,mulist)

                    dog.value
                    when (dogIndex.value) {
                        0 -> {
                            dog.value= "시내동지구"}
                        1 -> {
                            dog.value ="구정면"}
                        2 -> {dog.value ="왕산면"
                        }
                        3 -> {dog.value ="강동면"}
                        4 -> {dog.value ="사천면"}
                        5 ->{dog.value ="연곡면"}
                        6 -> {dog.value ="기타"}
                        else -> "기타"
                    }
                }
                else -> null
            }

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