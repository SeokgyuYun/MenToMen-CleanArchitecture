package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.request.LoginRequest

interface LoginDataSource {
    fun login(
        loginRequest: LoginRequest
    ): Flow<Login>
}