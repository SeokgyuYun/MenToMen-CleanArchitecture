package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.repository.LoginRepository
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import javax.inject.Inject

class DAuthLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(dAuthLoginRequest: DAuthLoginRequest): Flow<DAuthLogin> =
        loginRepository.dAuthLogin(dAuthLoginRequest)
}