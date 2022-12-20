package kr.hs.dgsw.b1nd.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody

interface FileRepository {
    fun getImageUrl(
        imageFile: List<MultipartBody.Part?>
    ): Flow<List<ImgUrl?>>
}