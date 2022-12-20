package kr.hs.dgsw.b1nd.domain.request

data class DAuthLoginRequest(
    val id: String,
    val pw: String,
    val clientId: String,
    val redirectUrl: String,
    val state: String? = null
)
