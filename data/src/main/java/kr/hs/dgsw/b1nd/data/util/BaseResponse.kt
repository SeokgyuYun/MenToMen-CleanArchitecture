package kr.hs.dgsw.b1nd.data.util

data class BaseResponse<T> (
    val status: Int,
    val message: String,
    val data: T
)