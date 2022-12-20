package kr.hs.dgsw.b1nd.domain.model

data class Login(
    val accessToken: String,
    val refreshToken: String
)
