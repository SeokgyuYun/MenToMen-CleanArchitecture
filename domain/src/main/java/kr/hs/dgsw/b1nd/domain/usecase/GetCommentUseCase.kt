package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.repository.CommentRepository
import javax.inject.Inject

class GetCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    operator fun invoke(postId: Int): Flow<List<Comment>> =
        commentRepository.getComment(postId)
}