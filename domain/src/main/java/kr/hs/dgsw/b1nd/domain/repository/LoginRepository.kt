package kr.hs.dgsw.b1nd.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import kr.hs.dgsw.b1nd.domain.request.LoginRequest

interface LoginRepository {
    fun dAuthLogin(
        dAuthLoginRequest: DAuthLoginRequest
    ): Flow<DAuthLogin>

    fun login(
        loginRequest: LoginRequest
    ): Flow<Login>
}