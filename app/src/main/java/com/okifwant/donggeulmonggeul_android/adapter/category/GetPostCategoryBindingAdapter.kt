package com.okifwant.donggeulmonggeul_android.adapter.category

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object GetPostCategoryBindingAdapter {

    @JvmStatic
    @BindingAdapter("set_img")
    fun setImg(imgView: ImageView, imgUrl: String) {

    }

    @JvmStatic
    @BindingAdapter("set_title")
    fun setTitle(text: TextView, title: String) {
        text.text = title
    }

    @JvmStatic
    @BindingAdapter("set_content")
    fun setContent(text: TextView, content: String) {
        text.text = content
    }

    @JvmStatic
    @BindingAdapter("set_name")
    fun setName(text: TextView, name: String) {
        text.text = name
    }
}