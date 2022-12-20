package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.repository.LoginRepository
import kr.hs.dgsw.b1nd.domain.request.LoginRequest
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(loginRequest: LoginRequest): Flow<Login> =
        loginRepository.login(loginRequest)
}