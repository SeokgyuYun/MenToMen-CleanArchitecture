package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.LoginDataSource
import kr.hs.dgsw.b1nd.data.service.LoginService
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.request.LoginRequest
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginService: LoginService
): LoginDataSource {
    override fun login(loginRequest: LoginRequest): Flow<Login> = flow {
        emit(loginService.login(loginRequest).data)
    }.flowOn(Dispatchers.IO)

}