package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.UserDataSource
import kr.hs.dgsw.b1nd.data.mapper.toEntity
import kr.hs.dgsw.b1nd.data.service.UserService
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.User
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService
): UserDataSource {
    override fun getUserInfo(): Flow<User> = flow {
        emit(userService.getUserInfo().data.toEntity())
    }.flowOn(Dispatchers.IO)

    override fun getUserPost(): Flow<List<Post>> = flow {
        emit(userService.getUserPost().data)
    }.flowOn(Dispatchers.IO)

}