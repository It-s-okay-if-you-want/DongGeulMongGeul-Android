package com.okifwant.donggeulmonggeul_android.viewmodel.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.BR
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.RecyclerItem
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.data.postdetail.PostDetailDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postDetailDataSource: PostDetailDataSource): BaseViewModel() {
    val postItems = MutableLiveData<List<RecyclerItem>>()

    var postId = -1

    fun getPostDetailData() {
        viewModelScope.launch {
            val response = postDetailDataSource.getPostDetail(postId)
            if(response.isSuccessful) {
                if(response.body() != null) {
                    val body = response.body()
                    postItems.value = ArrayList<RecyclerItem>().apply {
                        add(RecyclerItem(data = body!!.data.image, layoutId = R.layout.item_post_photo, variableId = BR.imageUrl))
                        add(RecyclerItem(data = PostDetailBody(body.data.title, body.data.content), layoutId = R.layout.item_post_body, variableId = BR.detail))
                        for(comment in body.data.comment) {
                            add(RecyclerItem(data = PostCommentViewModel(comment = comment.content, userName = comment.userId), layoutId = R.layout.item_post_comment, variableId = BR.comment))
                        }
                    }
                }

            }
        }

    }

    inner class PostCommentViewModel(val comment: String, val userName: String) {
        fun more() {

        }
    }
}

data class PostDetailBody(val title: String, val content: String)

