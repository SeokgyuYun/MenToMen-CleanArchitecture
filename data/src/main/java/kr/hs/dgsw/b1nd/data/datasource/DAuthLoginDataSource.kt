package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest

interface DAuthLoginDataSource {
    fun dAuthLogin(
        dAuthLoginRequest: DAuthLoginRequest
    ): Flow<DAuthLogin>
}