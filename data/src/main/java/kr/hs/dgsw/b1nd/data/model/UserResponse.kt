package kr.hs.dgsw.b1nd.data.model

import kr.hs.dgsw.b1nd.domain.model.StdInfo

data class UserResponse(
    val email: String,
    val name: String,
    val profileImage: String,
    val roles: String,
    val stdInfo: StdInfo,
    val userId: Int
)