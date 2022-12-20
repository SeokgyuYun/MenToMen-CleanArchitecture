package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest

interface CommentDataSource {
    fun getComment(
        postId: Int
    ): Flow<List<Comment>>

    fun submitComment(
        commentSubmitRequest: CommentSubmitRequest
    ): Flow<Unit>

    fun deleteComment(
        id: Int
    ): Flow<Unit>
}