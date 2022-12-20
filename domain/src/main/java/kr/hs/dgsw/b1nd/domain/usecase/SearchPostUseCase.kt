package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.repository.PostRepository
import javax.inject.Inject

class SearchPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(keyWord: String): Flow<List<Post>> =
        postRepository.searchPost(keyWord)
}