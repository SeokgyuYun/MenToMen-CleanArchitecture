package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.CommentDataSource
import kr.hs.dgsw.b1nd.data.mapper.toEntity
import kr.hs.dgsw.b1nd.data.service.CommentService
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest
import javax.inject.Inject


class CommentDataSourceImpl @Inject constructor(
    private val commentService: CommentService
): CommentDataSource {
    override fun getComment(postId: Int): Flow<List<Comment>> = flow {
       emit(commentService.getComment(postId).data.map { it.toEntity() })
    }.flowOn(Dispatchers.IO)

    override fun submitComment(commentSubmitRequest: CommentSubmitRequest): Flow<Unit> = flow {
        emit(commentService.submitComment(commentSubmitRequest).data)
    }.flowOn(Dispatchers.IO)

    override fun deleteComment(id: Int): Flow<Unit> = flow {
        emit(commentService.deleteComment(id).data)
    }

}