package com.okifwant.donggeulmonggeul_android.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.data.model.auth.Data
import com.okifwant.donggeulmonggeul_android.data.model.auth.Post

class ProfileAdapter(val fragment : Fragment,val data : List<Post>? ) : RecyclerView.Adapter<ProfileAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false))
    {
        val img = itemView.findViewById<ImageView>(R.id.profile_imageView)
        val category  = itemView.findViewById<TextView>(R.id.profile_title_text)
        val nickName = itemView.findViewById<TextView>(R.id.nickname_profile_textview)
        val title = itemView.findViewById<TextView>(R.id.profile_title_text)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.PagerViewHolder {
        return PagerViewHolder((parent))
    }

    override fun onBindViewHolder(holder: ProfileAdapter.PagerViewHolder, position: Int) {

        holder.category.setText(data?.get(position)?.category.toString())
        holder.nickName.setText(data?.get(position)?.userId.toString())
        holder.title.setText(data?.get(position)?.title.toString())

        if(data?.get(position)?.image != null) Glide.with(fragment.requireActivity()).load(data?.get(position)?.image).into(holder.img)
        else Log.d("NoPicker","NoPicker")
    }

    override fun getItemCount(): Int {
        return data!!.size
    }
}