package kr.hs.dgsw.b1nd.domain.request

data class PostSubmitRequest(
    val content : String,
    val imgUrls : List<ImgUrl?> = emptyList(),
    val tag : String
)
