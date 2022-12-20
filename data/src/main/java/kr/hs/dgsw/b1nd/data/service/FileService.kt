package kr.hs.dgsw.b1nd.data.service

import kr.hs.dgsw.b1nd.data.util.BaseResponse
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileService {
    @Multipart
    @POST("file/upload")
    suspend fun getImageUrl(
        @Part imageFile: List<MultipartBody.Part?>
    ): BaseResponse<List<ImgUrl?>>
}