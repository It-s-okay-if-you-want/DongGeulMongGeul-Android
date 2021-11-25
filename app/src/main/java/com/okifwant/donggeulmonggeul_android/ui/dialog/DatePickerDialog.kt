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
import com.okifwant.donggeulmonggeul_android.databinding.DialogDatePickerBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostTogetherViewModel
import java.time.LocalDate

class DatePickerDialog(private val viewModel: PostTogetherViewModel) : DialogFragment() {
    lateinit var binding: DialogDatePickerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_date_picker, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val currentTime = LocalDate.now()
        binding.run {
            dpYearNp.run {
                maxValue = currentTime.year + 1
                minValue = currentTime.year
                value = currentTime.year
            }

            dpMonthNp.run {
                maxValue = 12
                minValue = 1
                value = currentTime.monthValue
            }

            dpDayNp.run {
                maxValue = 31
                minValue = 1
                value = currentTime.dayOfMonth
            }

            dpCompleteTv.setOnClickListener {
                dismiss()
                viewModel.date.value = "${dpYearNp.value}.${dpMonthNp.value}.${dpDayNp.value}"
            }

            dpCancelTv.setOnClickListener {
                dismiss()
            }
        }
    }
}

