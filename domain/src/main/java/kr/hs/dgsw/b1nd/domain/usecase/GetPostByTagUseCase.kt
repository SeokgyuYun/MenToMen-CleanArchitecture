package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import javax.inject.Inject

class GetPostByTagUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(tag: String): Flow<List<Post>> =
        postRepository.getPostByTag(tag)
}