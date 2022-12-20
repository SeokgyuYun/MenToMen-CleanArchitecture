package kr.hs.dgsw.b1nd.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody

interface FileDataSource {
    fun getImageUrl(
        imageFile: List<MultipartBody.Part?>
    ): Flow<List<ImgUrl?>>
}