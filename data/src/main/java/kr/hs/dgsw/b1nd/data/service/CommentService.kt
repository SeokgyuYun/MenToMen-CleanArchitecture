package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.model.CommentResponse
import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest
import retrofit2.http.*

interface CommentService {
    @GET("comment/read/{postId}")
    suspend fun getComment(
        @Path("postId") postId: Int
    ): BaseResponse<List<CommentResponse>>

    @POST("comment/submit")
    suspend fun submitComment(
        @Body commentSubmitRequest: CommentSubmitRequest
    ): BaseResponse<Unit>

    @DELETE("comment/delete/{id}")
    suspend fun deleteComment(
        @Path("id") id: Int
    ): BaseResponse<Unit>
}