package kr.hs.dgsw.b1nd.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.hs.dgsw.b1nd.data.datasource.FileDataSource
import kr.hs.dgsw.b1nd.data.service.FileService
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody
import javax.inject.Inject

class FileDataSourceImpl @Inject constructor(
    private val fileService: FileService
): FileDataSource {
    override fun getImageUrl(imageFile: List<MultipartBody.Part?>): Flow<List<ImgUrl?>> = flow {
        emit(fileService.getImageUrl(imageFile).data)
    }.flowOn(Dispatchers.IO)

}