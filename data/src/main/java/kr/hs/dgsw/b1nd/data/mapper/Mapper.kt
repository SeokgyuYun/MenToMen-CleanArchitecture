package kr.hs.dgsw.b1nd.data.mapper

import kr.hs.dgsw.b1nd.data.model.CommentResponse
import kr.hs.dgsw.b1nd.data.model.DAuthLoginResponse
import kr.hs.dgsw.b1nd.data.model.UserResponse
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.model.DAuthLogin
import kr.hs.dgsw.b1nd.domain.model.User

fun DAuthLoginResponse.toEntity() = DAuthLogin(
    this.profileImage,
    this.location
)

fun UserResponse.toEntity() = User(
    this.name,
    this.profileImage,
    this.stdInfo,
    this.userId
)

fun CommentResponse.toEntity() = Comment(
    this.postId,
    this.content,
    this.profileUrl,
    this.commentId,
    this.userName
)