package kr.hs.dgsw.b1nd.domain.model

data class Comment(
    val commentId: Int,
    val content: String,
    val profileUrl: String,
    val userId: Int,
    val userName: String
)
