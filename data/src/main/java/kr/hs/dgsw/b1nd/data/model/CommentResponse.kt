package kr.hs.dgsw.b1nd.data.model

import kr.hs.dgsw.b1nd.domain.model.StdInfo

data class CommentResponse(
    val commentId: Int,
    val content: String,
    val createDateTime: String,
    val postId: Int,
    val profileUrl: String,
    val stdInfo: StdInfo,
    val updateDateTime: String,
    val userId: Int,
    val userName: String
)
