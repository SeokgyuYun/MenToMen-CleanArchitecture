package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.PostDataSource
import kr.hs.dgsw.b1nd.data.service.PostService
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.request.PostSubmitRequest
import kr.hs.dgsw.b1nd.domain.request.PostUpdateRequest
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postService: PostService
): PostDataSource {

    override fun getPost(): Flow<List<Post>> = flow {
        emit(postService.getPost().data)
    }.flowOn(Dispatchers.IO)

    override fun getPostByTag(tag: String): Flow<List<Post>> = flow {
        emit(postService.getPostByTag(tag).data)
    }.flowOn(Dispatchers.IO)

    override fun getPostByPostId(postId: Int): Flow<Post> = flow {
        emit(postService.getPostByPostId(postId).data)
    }.flowOn(Dispatchers.IO)

    override fun submitPost(postSubmitRequest: PostSubmitRequest): Flow<Unit> = flow {
        emit(postService.submitPost(postSubmitRequest).data)
    }.flowOn(Dispatchers.IO)

    override fun deletePost(postId: Int): Flow<Unit> = flow {
        emit(postService.deletePost(postId).data)
    }.flowOn(Dispatchers.IO)

    override fun updatePost(postUpdateRequest: PostUpdateRequest): Flow<Unit> = flow {
        emit(postService.updatePost(postUpdateRequest).data)
    }.flowOn(Dispatchers.IO)

    override fun searchPost(keyWord: String): Flow<List<Post>> = flow {
        emit(postService.searchPost(keyWord).data)
    }.flowOn(Dispatchers.IO)
}