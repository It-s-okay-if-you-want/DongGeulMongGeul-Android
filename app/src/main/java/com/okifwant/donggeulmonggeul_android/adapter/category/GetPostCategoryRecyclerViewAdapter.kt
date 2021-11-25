package com.okifwant.donggeulmonggeul_android.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.data.model.category.Data
import com.okifwant.donggeulmonggeul_android.data.model.category.GetPostCategory
import com.okifwant.donggeulmonggeul_android.databinding.CategoryCommunityRecyclerItemBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryInCommunityViewModel

class GetPostCategoryRecyclerViewAdapter (
    private val viewModel: CategoryInCommunityViewModel,
) : RecyclerView.Adapter<GetPostCategoryRecyclerViewAdapter.GetPostCategoryRecyclerViewHolder>() {

    init {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GetPostCategoryRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryCommunityRecyclerItemBinding>(
            layoutInflater,
            R.layout.category_community_recycler_item,
            parent,
            false
        )
        return GetPostCategoryRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GetPostCategoryRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.getPostCategoryList[position])
    }

    override fun getItemCount(): Int {
        return viewModel.getPostCategoryList.size
    }

    inner class GetPostCategoryRecyclerViewHolder(val binding: CategoryCommunityRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
            binding.executePendingBindings()
            binding.postCl.setOnClickListener {
                viewModel.clickedPost.value = data.idx
            }
        }
    }
}