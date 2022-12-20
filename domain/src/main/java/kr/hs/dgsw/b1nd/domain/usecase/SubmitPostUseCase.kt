package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import kr.hs.dgsw.b1nd.domain.request.PostSubmitRequest
import javax.inject.Inject

class SubmitPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(postSubmitRequest: PostSubmitRequest): Flow<Unit> =
        postRepository.submitPost(postSubmitRequest)
}