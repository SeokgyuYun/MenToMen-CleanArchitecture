package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.data.datasource.PostDataSource
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import kr.hs.dgsw.b1nd.domain.request.PostSubmitRequest
import kr.hs.dgsw.b1nd.domain.request.PostUpdateRequest
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
) : PostRepository {
    override fun getPost(): Flow<List<Post>> =
        postDataSource.getPost()

    override fun getPostByTag(tag: String): Flow<List<Post>> =
        postDataSource.getPostByTag(tag)

    override fun getPostByPostId(postId: Int): Flow<Post> =
        postDataSource.getPostByPostId(postId)

    override fun submitPost(postSubmitRequest: PostSubmitRequest): Flow<Unit> =
        postDataSource.submitPost(postSubmitRequest)

    override fun deletePost(postId: Int): Flow<Unit> =
        postDataSource.deletePost(postId)

    override fun updatePost(postUpdateRequest: PostUpdateRequest): Flow<Unit> =
        postDataSource.updatePost(postUpdateRequest)

    override fun searchPost(keyWord: String): Flow<List<Post>> =
        postDataSource.searchPost(keyWord)
}