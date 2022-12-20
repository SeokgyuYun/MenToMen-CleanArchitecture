package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.User

interface UserDataSource {
    fun getUserInfo(
    ): Flow<User>

    fun getUserPost(
    ): Flow<List<Post>>
}