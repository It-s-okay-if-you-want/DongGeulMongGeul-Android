package com.okifwant.donggeulmonggeul_android.adapter.tutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView
import com.okifwant.donggeulmonggeul_android.R


class PagerRecyclerAdapter() : RecyclerView.Adapter<PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tutorial_view_pager_item, parent, false))

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 4
}

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val img = itemView.findViewById<ImageView>(R.id.img)
    private val titleTxt = itemView.findViewById<TextView>(R.id.title_txt)
    private val contentTxt = itemView.findViewById<TextView>(R.id.content_txt)

    fun bind(position: Int) {
        titleTxt.text = titleTxtArray[position]
        contentTxt.text = contentTxtArray[position]
        img.setImageResource(imgResourceArray[position])
    }
}