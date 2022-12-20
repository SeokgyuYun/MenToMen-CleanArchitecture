package kr.hs.dgsw.b1nd.domain.request

data class CommentSubmitRequest(
    val content: String,
    val postId: Int
)
