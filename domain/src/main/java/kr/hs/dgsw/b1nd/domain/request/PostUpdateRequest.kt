package kr.hs.dgsw.b1nd.domain.request

data class PostUpdateRequest(
    val content: String,
    val imgUrls: List<ImgUrl?> = emptyList(),
    val postId: Int,
    val tag: String
)
