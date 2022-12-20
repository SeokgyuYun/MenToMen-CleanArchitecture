package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.data.datasource.FileDataSource
import kr.hs.dgsw.b1nd.domain.repository.FileRepository
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody
import javax.inject.Inject

class FileRepositoryImpl @Inject constructor(
    private val fileDataSource: FileDataSource
): FileRepository {
    override fun getImageUrl(imageFile: List<MultipartBody.Part?>): Flow<List<ImgUrl?>> =
        fileDataSource.getImageUrl(imageFile)
}