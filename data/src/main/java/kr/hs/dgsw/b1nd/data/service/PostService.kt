package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.request.PostSubmitRequest
import kr.hs.dgsw.b1nd.domain.request.PostUpdateRequest
import retrofit2.http.*

interface PostService {
    @GET("post/read-all")
    suspend fun getPost(
    ): BaseResponse<List<Post>>

    @GET("post/read-all/{tag}")
    suspend fun getPostByTag(
        @Path("tag") tag: String
    ): BaseResponse<List<Post>>

    @GET("post/read-one/{postId}")
    suspend fun getPostByPostId(
        @Path("postId") postId: Int
    ): BaseResponse<Post>

    @POST("post/submit")
    suspend fun submitPost(
        @Body postSubmitRequest: PostSubmitRequest
    ): BaseResponse<Unit>

    @DELETE("post/delete/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: Int
    ): BaseResponse<Unit>

    @PATCH("post/update")
    suspend fun updatePost(
        @Body postUpdateRequest: PostUpdateRequest
    ): BaseResponse<Unit>

    @GET("post/search/{keyWord}")
    suspend fun searchPost(
        @Path("keyWord") keyWord: String
    ): BaseResponse<List<Post>>
}