package com.okifwant.donggeulmonggeul_android.viewmodel.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.okifwant.donggeulmonggeul_android.BR
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.RecyclerItem
import com.okifwant.donggeulmonggeul_android.base.BaseViewModel
import com.okifwant.donggeulmonggeul_android.base.SingleLiveEvent
import com.okifwant.donggeulmonggeul_android.data.postdetail.PostDetailDataSource
import com.okifwant.donggeulmonggeul_android.dto.PostDetailData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postDetailDataSource: PostDetailDataSource) :
    BaseViewModel() {
    val postItems = MutableLiveData<List<RecyclerItem>>()

    var postId = -1

    val comment = MutableLiveData<String?>()

    val message = SingleLiveEvent<String>()

    val clickedCommentId = SingleLiveEvent<Int>()

    val startEditPost = SingleLiveEvent<Int>()

    val postData = MutableLiveData<PostDetailData>()

    val finish = SingleLiveEvent<Unit>()
    fun getPostDetailData() {
        viewModelScope.launch {
            val response = postDetailDataSource.getPostDetail(postId)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val body = response.body()!!
                    postData.value = body.data
                    postItems.value = ArrayList<RecyclerItem>().apply {
                        add(
                            RecyclerItem(
                                data = body.data.image ?: "",
                                layoutId = R.layout.item_post_photo,
                                variableId = BR.imageUrl
                            )
                        )
                        add(
                            RecyclerItem(
                                data = PostDetailBody(body.data.title, body.data.content),
                                layoutId = R.layout.item_post_body,
                                variableId = BR.detail
                            )
                        )
                        for (comment in body.data.comment) {
                            add(
                                RecyclerItem(
                                    data = PostCommentViewModel(
                                        comment = comment.content,
                                        userName = comment.userId,
                                        id = comment.idx
                                    ),
                                    layoutId = R.layout.item_post_comment,
                                    variableId = BR.comment
                                )
                            )
                        }
                    }
                }

            }
        }

    }

    inner class PostCommentViewModel(val comment: String, val userName: String, val id: Int) {
        fun more() {
            clickedCommentId.value = id
        }
    }

    fun postComment() {
        if (comment.value != null) {
            viewModelScope.launch {
                val response = postDetailDataSource.postComment(postId, comment.value!!)
                if (response.isSuccessful) {
                    getPostDetailData()
                    message.value = "댓글을 게시하였습니다"
                    comment.value = null
                }
            }
        }
    }

    fun reportPost() {
        viewModelScope.launch {
            val response = postDetailDataSource.reportPost(postId)
            if (response.isSuccessful) {
                message.value = "게시글에 섭섭함을 표시하였습니다"
            } else if (response.code() == 403) {
                message.value = "이미 섭섭함을 표시한 글입니다"
            }
        }
    }

    fun reportComment() {
        viewModelScope.launch {
            val response = postDetailDataSource.reportComment(clickedCommentId.value ?: 0)
            if (response.isSuccessful) {
                message.value = "댓글에 섭섭함을 표시하였습니다"
            } else if (response.code() == 403) {
                message.value = "이미 섭섭함을 표시한 글입니다"
            }
        }

    }

    fun deletePost() {
        viewModelScope.launch {
            val response = postDetailDataSource.deletePostDetail(postId)
            if(response.isSuccessful) {
                message.value = "삭제되었습니다"
                finish.call()
            }
        }
    }
}

data class PostDetailBody(val title: String, val content: String)

