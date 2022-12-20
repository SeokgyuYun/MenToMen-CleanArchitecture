package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import javax.inject.Inject

class GetPostByPostIdUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(postId: Int): Flow<Post> =
        postRepository.getPostByPostId(postId)
}