package com.okifwant.donggeulmonggeul_android.bindingadapter

import android.graphics.PorterDuff
import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.okifwant.donggeulmonggeul_android.R

@BindingAdapter("imageUri")
fun ImageView.setImageUri(uri: Uri?) {
    if(uri != null) {
        this.setImageURI(uri)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    val progressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        setColorFilter(ContextCompat.getColor(context, R.color.main_color), PorterDuff.Mode.SRC_IN)
        start()
    }

    Glide.with(context)
        .load(url)
        .placeholder(progressDrawable)
        .error(R.drawable.more)
        .into(this)
}