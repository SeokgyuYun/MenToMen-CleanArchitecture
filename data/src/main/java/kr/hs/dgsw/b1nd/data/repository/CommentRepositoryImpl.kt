package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.data.datasource.CommentDataSource
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.repository.CommentRepository
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentDataSource: CommentDataSource
): CommentRepository {
    override fun getComment(postId: Int): Flow<List<Comment>> =
        commentDataSource.getComment(postId)


    override fun submitComment(commentSubmitRequest: CommentSubmitRequest): Flow<Unit> =
        commentDataSource.submitComment(commentSubmitRequest)

    override fun deleteComment(id: Int): Flow<Unit> =
        commentDataSource.deleteComment(id)
}