package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.request.PostSubmitRequest
import kr.hs.dgsw.b1nd.domain.request.PostUpdateRequest

interface PostDataSource {
    fun getPost(
    ): Flow<List<Post>>

    fun getPostByTag(
        tag: String
    ): Flow<List<Post>>

    fun getPostByPostId(
        postId: Int
    ): Flow<Post>

    fun submitPost(
        postSubmitRequest: PostSubmitRequest
    ): Flow<Unit>

    fun deletePost(
        postId: Int
    ): Flow<Unit>

    fun updatePost(
        postUpdateRequest: PostUpdateRequest
    ): Flow<Unit>

    fun searchPost(
        keyWord: String
    ): Flow<List<Post>>
}