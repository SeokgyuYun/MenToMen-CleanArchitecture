package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import kr.hs.dgsw.b1nd.domain.request.PostUpdateRequest
import javax.inject.Inject

class UpdatePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(postUpdateRequest: PostUpdateRequest): Flow<Unit> =
        postRepository.updatePost(postUpdateRequest)
}