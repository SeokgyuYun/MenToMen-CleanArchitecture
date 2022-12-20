package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.DAuthLoginDataSource
import kr.hs.dgsw.b1nd.data.mapper.toEntity
import kr.hs.dgsw.b1nd.data.service.DAuthLoginService
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import javax.inject.Inject

class DAuthLoginDataSourceImpl @Inject constructor(
    private val dAuthLoginService: DAuthLoginService
): DAuthLoginDataSource {
    override fun dAuthLogin(dAuthLoginRequest: DAuthLoginRequest): Flow<DAuthLogin> = flow {
        emit(dAuthLoginService.dAuthLogin(dAuthLoginRequest).data.toEntity())
    }.flowOn(Dispatchers.IO)
}