package com.okifwant.donggeulmonggeul_android.bindingadapter

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageUri")
fun ImageView.setImageUri(uri: Uri?) {
    if(uri != null) {
        this.setImageURI(uri)
    }
}