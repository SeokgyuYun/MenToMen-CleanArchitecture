package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.model.DAuthLoginResponse
import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface DAuthLoginService {
    @POST("login")
    suspend fun dAuthLogin(
        @Body DAuthLoginRequest: DAuthLoginRequest
    ): BaseResponse<DAuthLoginResponse>

}