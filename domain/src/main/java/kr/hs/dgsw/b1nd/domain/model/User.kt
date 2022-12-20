package kr.hs.dgsw.b1nd.domain.model

data class User(
    val name: String,
    val profileImage: String?,
    val stdInfo: StdInfo,
    val userId: Int
)
