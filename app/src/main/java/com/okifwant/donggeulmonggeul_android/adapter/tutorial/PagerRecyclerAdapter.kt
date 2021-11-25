package com.okifwant.donggeulmonggeul_android.adapter.tutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.viewmodel.TutorialViewModel


class PagerRecyclerAdapter(
    val viewModel: TutorialViewModel
) : RecyclerView.Adapter<PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.tutorial_view_pager_item, parent, false), viewModel
        )

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 4
}

class PagerViewHolder(itemView: View, val viewModel: TutorialViewModel) :
    RecyclerView.ViewHolder(itemView) {
    private val img = itemView.findViewById<ImageView>(R.id.img)
    private val titleTxt = itemView.findViewById<TextView>(R.id.title_txt)
    private val contentTxt = itemView.findViewById<TextView>(R.id.content_txt)
    private val startBtn = itemView.findViewById<Button>(R.id.start_btn)

    fun bind(position: Int) {
        when (position) {
            3 -> startBtn.visibility = View.VISIBLE
            else -> startBtn.visibility = View.INVISIBLE
        }
        titleTxt.text = titleTxtArray[position]
        contentTxt.text = contentTxtArray[position]
        img.setImageResource(imgResourceArray[position])

        startBtn.setOnClickListener {
            viewModel.setStartBtnClickEvent()
        }
    }
}