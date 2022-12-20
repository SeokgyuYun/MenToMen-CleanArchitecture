package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.repository.CommentRepository
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest
import javax.inject.Inject

class SubmitCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    operator fun invoke(commentSubmitRequest: CommentSubmitRequest): Flow<Unit> =
        commentRepository.submitComment(commentSubmitRequest)
}