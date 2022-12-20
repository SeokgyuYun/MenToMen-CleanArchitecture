package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.data.datasource.UserDataSource
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.User
import kr.hs.dgsw.b1nd.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {
    override fun getUserInfo(): Flow<User> =
        userDataSource.getUserInfo()


    override fun getUserPost(): Flow<List<Post>> =
        userDataSource.getUserPost()
}