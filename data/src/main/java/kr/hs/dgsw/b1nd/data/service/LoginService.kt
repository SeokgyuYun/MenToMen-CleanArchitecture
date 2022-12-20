package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.model.Login
import kr.hs.dgsw.b1nd.domain.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("auth/code")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): BaseResponse<Login>
}