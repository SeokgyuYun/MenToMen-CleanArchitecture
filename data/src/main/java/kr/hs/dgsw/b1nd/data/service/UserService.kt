package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.model.UserResponse
import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.model.Post
import retrofit2.http.GET

interface UserService {
    @GET("user/my")
    suspend fun getUserInfo(
    ): BaseResponse<UserResponse>

    @GET("user/post")
    suspend fun getUserPost(
    ): BaseResponse<List<Post>>
}