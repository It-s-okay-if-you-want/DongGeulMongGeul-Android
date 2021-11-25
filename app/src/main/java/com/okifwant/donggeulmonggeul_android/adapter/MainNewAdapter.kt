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
import com.okifwant.donggeulmonggeul_android.data.model.auth.Post
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Data

class MainNewAdapter(fragment : Fragment,data : List<Data>? ) : RecyclerView.Adapter<MainNewAdapter.PagerViewHolder>()  {

    var fragment = fragment

    var data = data

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainNewAdapter.PagerViewHolder {

       return PagerViewHolder((parent))
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.new_popularity_viewpager_item, parent, false))
    {
        val img = itemView.findViewById<ImageView>(R.id.new_post_imageView)
        val category  = itemView.findViewById<TextView>(R.id.category_textview)
        val nickName = itemView.findViewById<TextView>(R.id.nickname_textview)
        val title = itemView.findViewById<TextView>(R.id.title_textView)
    }

    override fun onBindViewHolder(holder: MainNewAdapter.PagerViewHolder, position: Int) {

        holder.category.setText(data?.get(position)?.category.toString())
        holder.nickName.setText(data?.get(position)?.userId.toString())
        holder.title.setText(data?.get(position)?.title.toString())

        if(data?.get(position)?.image != null) Glide.with(fragment.requireActivity()).load(data?.get(position)?.image).into(holder.img)
        else Log.d("NoPicker","NoPicker")
    }

    override fun getItemCount(): Int {
        return 6
    }
}