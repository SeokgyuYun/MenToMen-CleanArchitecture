package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.data.datasource.DAuthLoginDataSource
import kr.hs.dgsw.b1nd.data.datasource.LoginDataSource
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.repository.LoginRepository
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import kr.hs.dgsw.b1nd.domain.request.LoginRequest
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource,
    private val dAuthLoginDataSource: DAuthLoginDataSource
) : LoginRepository {
    override fun dAuthLogin(dAuthLoginRequest: DAuthLoginRequest): Flow<DAuthLogin> =
        dAuthLoginDataSource.dAuthLogin(dAuthLoginRequest)

    override fun login(loginRequest: LoginRequest): Flow<Login> =
        loginDataSource.login(loginRequest)
}